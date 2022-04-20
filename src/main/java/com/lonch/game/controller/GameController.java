package com.lonch.game.controller;

import com.lonch.game.dto.*;
import com.lonch.game.entity.ChessBoardEntity;
import com.lonch.game.entity.GameEntity;
import com.lonch.game.entity.PersonEntity;
import com.lonch.game.entity.Chess;
import com.lonch.game.enums.ChessColorEnum;
import com.lonch.game.enums.CommonEnum;
import com.lonch.game.request.*;
import com.lonch.game.response.ChooseColorResp;
import com.lonch.game.response.CnResult;
import com.lonch.game.response.OpenGameResp;
import com.lonch.game.response.PutChessResp;
import com.lonch.game.service.GameService;
import com.lonch.game.utils.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @description:
 * @author: lpx
 * @create: 2022-02-05 23:12
 */
@RestController
@RequestMapping("/blackandwhite")
public class GameController {

    @Resource
    private GameService gameService;

    //游戏集合
    Map<String,GameEntity> gameList = new HashMap<String,GameEntity>();

    /**
     * 开始游戏
     * @return
     */
    @PostMapping("/openGame")
    public CnResult openGame(@RequestBody OpenGameRequest baseRequest){

        OpenGameDto openGameDto=baseRequest.getParam();
        GameEntity gameEntity=new GameEntity();
        String uuid=UUID.randomUUID().toString().replace("-", "");
        ChessBoardEntity chessBoardEntity=new ChessBoardEntity();
        chessBoardEntity.setChess(InitChessboardUtil.initChessboard());

        //棋手
        PersonEntity blackPenson=new PersonEntity();
        blackPenson.setPersonColor(CommonEnum.COLOR_BLACK.getCode());
        PersonEntity whitePenson = new PersonEntity();
        whitePenson.setPersonColor(CommonEnum.COLOR_WHITE.getCode());
        Map<String,PersonEntity> personMap=new HashMap<>();
        personMap.put(CommonEnum.COLOR_BLACK.getCode(),blackPenson);
        personMap.put(CommonEnum.COLOR_WHITE.getCode(),whitePenson);
        gameEntity.setPersonMap(personMap);

        gameEntity.setGameType(openGameDto.getGameType());
        gameEntity.setId(uuid);
        gameEntity.setChessBoardEntity(chessBoardEntity);

        gameList.put(uuid, gameEntity);

        OpenGameResp resp=new OpenGameResp();
        resp.setGameId(uuid);
        return CnResult.success(resp);
    }

    @PostMapping("/chooseColor")
    public CnResult chooseColor(@RequestBody ChooseColorRequest baseRequest){


        ChooseColorResp resp=new ChooseColorResp();

        ChooseColorDto chooseColorDto=baseRequest.getParam();

        GameEntity gameEntity=gameList.get(chooseColorDto.getGameId());

        //设置棋手具体信息==
        if(gameEntity.getGameType()==1){
            if(ChessColorEnum.COLOR_WHITE.getCode()==chooseColorDto.getColorType()){
                gameEntity.getPersonMap().get(ChessColorEnum.COLOR_BLACK.getColorName()).setAuto(true);
            }else{
                gameEntity.getPersonMap().get(ChessColorEnum.COLOR_WHITE.getColorName()).setAuto(true);
            }

            ChessColorStringDto firstChess=null;
            if(chooseColorDto.getColorType()==ChessColorEnum.COLOR_WHITE.getCode()){
                firstChess=gameService.autoPutChess(gameEntity,CommonEnum.COLOR_BLACK.getCode());
            }
            resp.setFirstChess(firstChess);
        }

        resp.setConfirmed(true);
        resp.setGameId(chooseColorDto.getGameId());

        return CnResult.success(resp);
    }


    @PostMapping("/putChess")
    public CnResult putChess(@RequestBody PutChessRequest baseRequest){
        PutChessResp resp = new PutChessResp();
        PutChessDto putChessDto= baseRequest.getParam();
        GameEntity gameEntity=gameList.get(putChessDto.getGameId());

        Chess chess= ChessUtil.transDto2Entity(putChessDto.getChess());

        Boolean flag=gameService.checkValid(gameEntity,chess);
        if(!flag){
            return CnResult.fail("不可以下在此处");
        }
        gameService.putChess(gameEntity,chess);
        //判断下一个落子方是否是电脑自动下子
        if(gameEntity.getGameType()==1){
            ChessColorStringDto chessColorStringDto = null;
            if(ChessColorEnum.COLOR_WHITE.getCode()==putChessDto.getChess().getColorType()){
                if(gameEntity.getPersonMap().get(ChessColorEnum.COLOR_BLACK.getColorName()).getAuto()){
                    chessColorStringDto=gameService.autoPutChess(gameEntity,ChessColorEnum.COLOR_BLACK.getColorName());
                }
            }else{
                if(gameEntity.getPersonMap().get(ChessColorEnum.COLOR_WHITE.getColorName()).getAuto()){
                    chessColorStringDto=gameService.autoPutChess(gameEntity,ChessColorEnum.COLOR_WHITE.getColorName());
                }
            }
            resp.setComputerResponseChess(chessColorStringDto);
        }
        return CnResult.success(resp);
    }

}

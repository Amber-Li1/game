package com.lonch.game.utils;

import com.lonch.game.dto.ChessColorStringDto;
import com.lonch.game.dto.ChessDto;
import com.lonch.game.entity.Chess;
import com.lonch.game.enums.ChessColorEnum;
import com.lonch.game.enums.CommonEnum;
import org.springframework.util.StringUtils;

/**
 * @description:
 * @author: lpx
 * @create: 2022-04-01 23:26
 */
public class ChessUtil {

    public static Chess transDto2Entity(ChessDto chessDto){
        Chess chess=new Chess();
        chess.setX(chessDto.getX());
        chess.setY(chessDto.getY());
        if(chessDto.getColorType()== ChessColorEnum.COLOR_BLACK.getCode()){
            chess.setColorType(ChessColorEnum.COLOR_BLACK.getColorName());
        }
        if(chessDto.getColorType()== ChessColorEnum.COLOR_WHITE.getCode()){
            chess.setColorType(ChessColorEnum.COLOR_WHITE.getColorName());
        }

        return chess;
    }

    public static ChessColorStringDto transEntity2ChessColorStringDto(Chess chess){
        ChessColorStringDto chessColorStringDto=new ChessColorStringDto();
        chessColorStringDto.setX(chess.getX());
        chessColorStringDto.setY(chess.getY());
        chessColorStringDto.setColorType(chess.getColorType());

        return chessColorStringDto;
    }

    public static String getAnotherColor(String color){
        String anotherColer="";
        if(color.equals(CommonEnum.COLOR_BLACK.getCode())){
            anotherColer=CommonEnum.COLOR_WHITE.getCode();
        }
        if(color.equals(CommonEnum.COLOR_WHITE.getCode())){
            anotherColer=CommonEnum.COLOR_BLACK.getCode();
        }
        return anotherColer;
    }

}

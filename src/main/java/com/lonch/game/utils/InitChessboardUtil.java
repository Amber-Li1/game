package com.lonch.game.utils;

import com.lonch.game.constants.Scores;
import com.lonch.game.entity.Chess;
import com.lonch.game.enums.CommonEnum;

/**
 * @description:初始化棋盘
 * @author: lpx
 * @create: 2022-02-06 19:09
 */
public class InitChessboardUtil {

    //初始化棋盘
    public static Chess[][] initChessboard(){
        Chess[][] chessboard=new Chess[8][8];
        //初始化棋子
        Chess white1=new Chess();
        Chess white2=new Chess();
        Chess black1=new Chess();
        Chess black2=new Chess();

        //白子1-左上
        white1.colorType= CommonEnum.COLOR_WHITE.getCode();
        white1.setX(3);
        white1.setY(3);
        white1.right=black1;
        white1.behind=black2;
        white1.rightbehind=white2;

        //白子2--右下
        white2.colorType=CommonEnum.COLOR_WHITE.getCode();
        white2.setX(4);
        white2.setY(4);
        white2.front=black1;
        white2.leftfront=white1;
        white2.left=black2;

        //黑子1--右上
        black1.colorType=CommonEnum.COLOR_BLACK.getCode();
        black1.setX(3);
        black1.setY(4);
        black1.left=white1;
        black1.leftbehind=black2;
        black1.behind=white2;

        //黑子2--左下
        black2.colorType=CommonEnum.COLOR_BLACK.getCode();
        black2.setX(4);
        black2.setY(3);
        black2.front=white1;
        black2.rightfront=black1;
        black2.right=white2;

        chessboard[3][3]= white1;
        chessboard[3][4]= black1;
        chessboard[4][3]= black2;
        chessboard[4][4]= white2;
        return chessboard;
    }



}

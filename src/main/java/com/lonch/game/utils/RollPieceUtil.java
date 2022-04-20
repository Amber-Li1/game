package com.lonch.game.utils;

import com.lonch.game.entity.Chess;

/**
 * @description: 翻转棋子
 * @author: lpx
 * @create: 2022-02-06 19:46
 */
public class RollPieceUtil {

    public static void rollFront(Chess[][] chessboard, Chess chess, int[] hasPieces){
        Chess chessNew = chess.getFront();
        if(chessNew.x==hasPieces[0] && chessNew.y == hasPieces[1]){
            return;
        }
        chessboard[chessNew.x][chessNew.y].colorType= chess.getColorType();
        rollFront(chessboard, chessNew,hasPieces);
    }

    /**
     * 左上方向的棋子翻转
     * @param chess
     * @param chess
     * @param hasPieces
     */
    public static void rollLeftFront(Chess[][] chessboard, Chess chess, int[] hasPieces){
        Chess chessNew = chess.getLeftfront();
        if(chessNew.x==hasPieces[0] && chessNew.y == hasPieces[1]){
            return;
        }
        chessboard[chessNew.x][chessNew.y].colorType= chess.getColorType();
        rollLeftFront(chessboard, chessNew,hasPieces);
    }

    /**
     * 左侧方向的棋子翻转
     * @param chess
     * @param chess
     * @param hasPieces
     */
    public static void rollLeft(Chess[][] chessboard, Chess chess, int[] hasPieces){
        Chess chessNew = chess.getLeft();
        if(chessNew.x==hasPieces[0] && chessNew.y == hasPieces[1]){
            return;
        }
        chessboard[chessNew.x][chessNew.y].colorType= chess.getColorType();
        rollLeft(chessboard, chessNew,hasPieces);
    }
    /**
     * 左下方向的棋子翻转
     * @param chess
     * @param chess
     * @param hasPieces
     */
    public static void rollLeftBehind(Chess[][] chessboard, Chess chess, int[] hasPieces){
        Chess chessNew = chess.getLeftbehind();
        if(chessNew.x==hasPieces[0] && chessNew.y == hasPieces[1]){
            return;
        }
        chessboard[chessNew.x][chessNew.y].colorType= chess.getColorType();
        rollLeftBehind(chessboard, chessNew,hasPieces);
    }

    /**
     * 正下方向的棋子翻转
     * @param chess
     * @param chess
     * @param hasPieces
     */
    public static void rollBehind(Chess[][] chessboard, Chess chess, int[] hasPieces){
        Chess chessNew = chess.getBehind();
        if(chessNew.x==hasPieces[0] && chessNew.y == hasPieces[1]){
            return;
        }
        chessboard[chessNew.x][chessNew.y].colorType= chess.getColorType();
        rollBehind(chessboard, chessNew,hasPieces);
    }

    /**
     * 右下方向的棋子翻转
     * @param chess
     * @param chess
     * @param hasPieces
     */
    public static void rollRightBehind(Chess[][] chessboard, Chess chess, int[] hasPieces){
        Chess chessNew = chess.getRightbehind();
        if(chessNew.x==hasPieces[0] && chessNew.y == hasPieces[1]){
            return;
        }
        chessboard[chessNew.x][chessNew.y].colorType= chess.getColorType();
        rollRightBehind(chessboard, chessNew,hasPieces);
    }

    /**
     * 右侧方向的棋子翻转
     * @param chess
     * @param chess
     * @param hasPieces
     */
    public static void rollRight(Chess[][] chessboard, Chess chess, int[] hasPieces){
        Chess chessNew = chess.getRight();
        if(chessNew.x==hasPieces[0] && chessNew.y == hasPieces[1]){
            return;
        }
        chessboard[chessNew.x][chessNew.y].colorType= chess.getColorType();
        rollRight(chessboard, chessNew,hasPieces);
    }

    /**
     * 右上方向的棋子翻转
     * @param chess
     * @param chess
     * @param hasPieces
     */
    public static void rollRightFront(Chess[][] chessboard, Chess chess, int[] hasPieces){
        Chess chessNew = chess.getRightfront();
        if(chessNew.x==hasPieces[0] && chessNew.y == hasPieces[1]){
            return;
        }
        chessboard[chessNew.x][chessNew.y].colorType= chess.getColorType();
        rollRightFront(chessboard, chessNew,hasPieces);
    }

}

package com.lonch.game.entity;

import java.io.Serializable;

/**
 * @description: 棋盘类
 * @author: lpx
 * @create: 2022-03-16 17:06
 */
public class ChessBoardEntity implements Serializable {

    public Chess[][] chess;

    public Chess[][] getChess() {
        return chess;
    }

    public void setChess(Chess[][] chess) {
        this.chess = chess;
    }
}

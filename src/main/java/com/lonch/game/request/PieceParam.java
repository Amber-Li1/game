package com.lonch.game.request;

import com.lonch.game.entity.Chess;

/**
 * @description: 校验落子合法性的入参
 * @author: lpx
 * @create: 2022-02-06 13:59
 */
public class PieceParam {

    public Chess chess;

    public String gameId;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Chess getPiece() {
        return chess;
    }

    public void setPiece(Chess chess) {
        this.chess = chess;
    }
}

package com.lonch.game.dto;

import com.lonch.game.entity.Chess;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-17 09:33
 */
public class PutChessDto {
    public ChessDto chess;
    public String gameId;

    public ChessDto getChess() {
        return chess;
    }

    public void setChess(ChessDto chess) {
        this.chess = chess;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}

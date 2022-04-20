package com.lonch.game.response;

import com.lonch.game.dto.ChessColorStringDto;
import com.lonch.game.entity.Chess;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-16 20:54
 */
public class PutChessResp {

    public ChessColorStringDto computerResponseChess;
    public String gameId;
    public String victory;

    public ChessColorStringDto getComputerResponseChess() {
        return computerResponseChess;
    }

    public void setComputerResponseChess(ChessColorStringDto computerResponseChess) {
        this.computerResponseChess = computerResponseChess;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getVictory() {
        return victory;
    }

    public void setVictory(String victory) {
        this.victory = victory;
    }
}

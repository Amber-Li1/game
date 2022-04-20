package com.lonch.game.response;

import com.lonch.game.dto.ChessColorStringDto;
import com.lonch.game.dto.ChessDto;
import com.lonch.game.entity.Chess;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-16 19:44
 */
public class ChooseColorResp {
    public Boolean confirmed;
    public ChessColorStringDto firstChess;
    public String gameId;

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public ChessColorStringDto getFirstChess() {
        return firstChess;
    }

    public void setFirstChess(ChessColorStringDto firstChess) {
        this.firstChess = firstChess;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}

package com.lonch.game.dto;

import java.io.Serializable;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-17 09:42
 */
public class OpenGameDto  implements Serializable {
    public int dimension;
    public int gameType;

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }
}

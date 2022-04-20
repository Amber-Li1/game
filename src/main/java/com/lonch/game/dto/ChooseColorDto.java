package com.lonch.game.dto;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-17 09:40
 */
public class ChooseColorDto {
    private int colorType;
    private String gameId;

    public int getColorType() {
        return colorType;
    }

    public void setColorType(int colorType) {
        this.colorType = colorType;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}

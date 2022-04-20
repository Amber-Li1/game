package com.lonch.game.enums;

public enum ChessColorEnum {

    //棋子颜色-白色
    COLOR_WHITE(2,"White"),
    //棋子颜色-黑色
    COLOR_BLACK(1,"Black");

    private int code;
    private String colorName;

    ChessColorEnum(int code, String colorName) {
        this.code=code;
        this.colorName=colorName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}

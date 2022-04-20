package com.lonch.game.enums;

/**
 * @description:
 * @author: lpx
 * @create: 2022-02-06 14:10
 */
public enum CommonEnum {

    //棋子颜色-白色
    COLOR_WHITE("White","WHITE"),
    //棋子颜色-黑色
    COLOR_BLACK("Black","BLACK");

    private String code;
    private String colorName;

    CommonEnum(String code, String colorName) {
        this.code=code;
        this.colorName=colorName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}

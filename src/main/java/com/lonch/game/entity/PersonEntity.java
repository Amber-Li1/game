package com.lonch.game.entity;

import java.io.Serializable;

/**
 * @description: 棋手类
 * @author: lpx
 * @create: 2022-03-16 17:02
 */
public class PersonEntity implements Serializable {

    public String personColor;

    public Boolean isAuto;

    public String getPersonColor() {
        return personColor;
    }

    public void setPersonColor(String personColor) {
        this.personColor = personColor;
    }

    public Boolean getAuto() {
        return isAuto;
    }

    public void setAuto(Boolean auto) {
        isAuto = auto;
    }
}

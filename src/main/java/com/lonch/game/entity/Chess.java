package com.lonch.game.entity;

import java.io.Serializable;

/**
 * @description: 棋子
 * @author: lpx
 * @create: 2022-02-06 10:23
 */
public class Chess implements Serializable {

    public String colorType;

    public int x;
    public int y;

    public Chess front;
    public Chess behind;
    public Chess left;
    public Chess right;
    public Chess leftfront;
    public Chess leftbehind;
    public Chess rightfront;
    public Chess rightbehind;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public Chess getFront() {
        return front;
    }

    public void setFront(Chess front) {
        this.front = front;
    }

    public Chess getBehind() {
        return behind;
    }

    public void setBehind(Chess behind) {
        this.behind = behind;
    }

    public Chess getLeft() {
        return left;
    }

    public void setLeft(Chess left) {
        this.left = left;
    }

    public Chess getRight() {
        return right;
    }

    public void setRight(Chess right) {
        this.right = right;
    }

    public Chess getLeftfront() {
        return leftfront;
    }

    public void setLeftfront(Chess leftfront) {
        this.leftfront = leftfront;
    }

    public Chess getLeftbehind() {
        return leftbehind;
    }

    public void setLeftbehind(Chess leftbehind) {
        this.leftbehind = leftbehind;
    }

    public Chess getRightfront() {
        return rightfront;
    }

    public void setRightfront(Chess rightfront) {
        this.rightfront = rightfront;
    }

    public Chess getRightbehind() {
        return rightbehind;
    }

    public void setRightbehind(Chess rightbehind) {
        this.rightbehind = rightbehind;
    }
}

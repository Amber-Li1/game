package com.lonch.game.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * @description: 游戏类
 * @author: lpx
 * @create: 2022-03-16 17:00
 */
public class GameEntity implements Serializable {
    public String id;
//    public PersonEntity blackPerson;
//    public PersonEntity whitePerson;
    public Map<String,PersonEntity> personMap;
    public ChessBoardEntity chessBoardEntity;
    public int gameType;
    public int dimension;

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public PersonEntity getBlackPerson() {
//        return blackPerson;
//    }
//
//    public void setBlackPerson(PersonEntity blackPerson) {
//        this.blackPerson = blackPerson;
//    }
//
//    public PersonEntity getWhitePerson() {
//        return whitePerson;
//    }
//
//    public void setWhitePerson(PersonEntity whitePerson) {
//        this.whitePerson = whitePerson;
//    }


    public Map<String, PersonEntity> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(Map<String, PersonEntity> personMap) {
        this.personMap = personMap;
    }

    public ChessBoardEntity getChessBoardEntity() {
        return chessBoardEntity;
    }

    public void setChessBoardEntity(ChessBoardEntity chessBoardEntity) {
        this.chessBoardEntity = chessBoardEntity;
    }
}

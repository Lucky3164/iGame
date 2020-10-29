package com.igame.entity;

import java.io.Serializable;

public class GameInfo implements Serializable {
    private Integer gameId;

    private String gameName;

    private Integer gameType;

    private Integer views;

    private String gameCoverImg;

    private String publisher;

    private String gameIntroduce;

    private String gameplay;

    private GameType type;

    @Override
    public String toString() {
        return "GameInfo{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", gameType=" + gameType +
                ", views=" + views +
                ", gameCoverImg='" + gameCoverImg + '\'' +
                ", publisher='" + publisher + '\'' +
                ", gameIntroduce='" + gameIntroduce + '\'' +
                ", gameplay='" + gameplay + '\'' +
                ", type=" + type +
                '}';
    }

    public GameInfo() {
    }

    public GameInfo(String gameName, Integer gameType, String gameCoverImg, String publisher, String gameIntroduce, String gameplay) {
        this.gameName = gameName;
        this.gameType = gameType;
        this.gameCoverImg = gameCoverImg;
        this.publisher = publisher;
        this.gameIntroduce = gameIntroduce;
        this.gameplay = gameplay;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public String getGameCoverImg() {
        return gameCoverImg;
    }

    public void setGameCoverImg(String gameCoverImg) {
        this.gameCoverImg = gameCoverImg == null ? null : gameCoverImg.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getGameIntroduce() {
        return gameIntroduce;
    }

    public void setGameIntroduce(String gameIntroduce) {
        this.gameIntroduce = gameIntroduce == null ? null : gameIntroduce.trim();
    }

    public String getGameplay() {
        return gameplay;
    }

    public void setGameplay(String gameplay) {
        this.gameplay = gameplay == null ? null : gameplay.trim();
    }
}
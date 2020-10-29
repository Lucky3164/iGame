package com.igame.entity;

import java.io.Serializable;

public class GameScore implements Serializable {
    private Integer scoreId;

    private Float scoreCount;

    private Integer userId;

    private Integer gameId;

    @Override
    public String toString() {
        return "GameScore{" +
                "scoreId=" + scoreId +
                ", scoreCount=" + scoreCount +
                ", userId=" + userId +
                ", gameId=" + gameId +
                '}';
    }

    public GameScore() {
    }

    public GameScore(Float scoreCount, Integer userId, Integer gameId) {
        this.scoreCount = scoreCount;
        this.userId = userId;
        this.gameId = gameId;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Float getScoreCount() {
        return scoreCount;
    }

    public void setScoreCount(Float scoreCount) {
        this.scoreCount = scoreCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
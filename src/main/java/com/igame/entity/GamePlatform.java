package com.igame.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GamePlatform implements Serializable {
    private Integer gameId;

    private Integer platformId;

    private BigDecimal gamePrice;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private Platform platform;

    @Override
    public String toString() {
        return "GamePlatform{" +
                "gameId=" + gameId +
                ", platformId=" + platformId +
                ", gamePrice=" + gamePrice +
                ", releaseDate=" + releaseDate +
                ", platform=" + platform +
                '}';
    }

    public GamePlatform() {
    }

    public GamePlatform(Integer gameId, Integer platformId, BigDecimal gamePrice, Date releaseDate) {
        this.gameId = gameId;
        this.platformId = platformId;
        this.gamePrice = gamePrice;
        this.releaseDate = releaseDate;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public BigDecimal getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(BigDecimal gamePrice) {
        this.gamePrice = gamePrice;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
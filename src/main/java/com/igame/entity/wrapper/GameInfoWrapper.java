package com.igame.entity.wrapper;

import com.igame.entity.GameInfo;
import com.igame.entity.GamePlatform;
import com.igame.entity.GameScore;
import com.igame.entity.GameTag;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-11 16:56
 */
public class GameInfoWrapper implements Serializable {

    private GameInfo gameInfo;

    private final Map<Integer, GamePlatform> gamePlatformMap = new HashMap<>();

    private List<GameTag> tags;

    private List<GameScore> scores;

    private Integer views = 0;

    private Float aveScore;

    @Override
    public String toString() {
        return "GameInfoWrapper{" +
                "gameInfo=" + gameInfo +
                ", gamePlatformMap=" + gamePlatformMap +
                ", tags=" + tags +
                ", scores=" + scores +
                ", aveScore=" + aveScore +
                '}';
    }

    public GameInfoWrapper() {
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views == null ? 0 : views;
    }

    public Float getAveScore() {
        return aveScore;
    }

    public void setAveScore(Float aveScore) {
        this.aveScore = aveScore;
    }

    public List<GameScore> getScores() {
        return scores;
    }

    public void setScores(List<GameScore> scores) {
        this.scores = scores;
        Float countScore = 0f;
        for (GameScore score : scores) {
            countScore += score.getScoreCount();
        }
        this.aveScore = scores.size() > 0 ? countScore / scores.size() : null;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public void setGameInfo(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    public Map<Integer, GamePlatform> getGamePlatformMap() {
        return gamePlatformMap;
    }

    public void setGamePlatformMap(List<GamePlatform> gamePlatformList) {
        for (GamePlatform gamePlatform : gamePlatformList) {
            this.gamePlatformMap.put(gamePlatform.getPlatformId(), gamePlatform);
        }
    }

    public List<GameTag> getTags() {
        return tags;
    }

    public void setTags(List<GameTag> tags) {
        this.tags = tags;
    }

    public GamePlatform getFirstPlatform() {
        for (Map.Entry<Integer, GamePlatform> entry : this.gamePlatformMap.entrySet()) {
            return entry.getValue();
        }
        return null;
    }
}

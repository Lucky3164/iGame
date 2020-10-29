package com.igame.service.impl;

import com.igame.entity.GameScore;
import com.igame.mapper.GameScoreMapper;
import com.igame.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-17 22:13
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    GameScoreMapper gameScoreMapper;

    @Override
    public int insertScore(Integer gid, Integer uid, Float score) {
        GameScore ckScore = selectScoreByGidUid(gid, uid);
        if (ckScore != null) {
            return -1;
        }
        GameScore gameScore = new GameScore();
        gameScore.setUserId(uid);
        gameScore.setGameId(gid);
        gameScore.setScoreCount(score);
        return gameScoreMapper.insert(gameScore);
    }

    @Override
    public List<GameScore> selectScoreByGid(Integer gid) {
        GameScore score = new GameScore();
        score.setGameId(gid);
        return gameScoreMapper.selectDynamic(score);
    }

    @Override
    public GameScore selectScoreByGidUid(Integer gid, Integer uid) {
        GameScore score = new GameScore();
        score.setGameId(gid);
        score.setUserId(uid);
        List<GameScore> gameScores = gameScoreMapper.selectDynamic(score);

        return gameScores.size() > 0 ? gameScores.get(0) : null;
    }
}

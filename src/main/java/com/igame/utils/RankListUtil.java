package com.igame.utils;

import com.alibaba.fastjson.JSON;
import com.igame.entity.wrapper.GameInfoWrapper;
import com.igame.mapper.wrapper.GameInfoWrapperMapper;
import com.igame.service.GameInfoService;
import com.igame.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 排行榜
 *
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-25 16:21
 */
@Component
public class RankListUtil{

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    GameInfoService gameInfoService;

    public static final String RANK_VIEWS = "gameViewsRank";
    public static final String RANK_SCORE = "gameScoreRank";

//    @PostConstruct
//    public void init() {
//        List<GameInfoWrapper> games = gameInfoService.selectAll();
//        for (GameInfoWrapper game : games) {
//            redisUtil.zAdd(RANK_VIEWS, game.getGameInfo().getGameId(), -game.getGameInfo().getViews());
//        }
//    }

    private List<GameInfoWrapper> buildRank(Set<ZSetOperations.TypedTuple<Object>> result){
        List<GameInfoWrapper> rankList = new ArrayList<>();

        for (ZSetOperations.TypedTuple<Object> gameId : result) {
            rankList.add(gameInfoService.selectByGameId((Integer) gameId.getValue()));
        }
        return rankList;
    }

    public List<GameInfoWrapper> getTopN(int n){
        Set<ZSetOperations.TypedTuple<Object>> result = redisUtil.zRangeWithScore(RANK_VIEWS, 0, n-1);
        if(result.isEmpty()){
            gameInfoService.rankByViews();
        }
        result = redisUtil.zRangeWithScore(RANK_VIEWS, 0, n-1);
        return buildRank(result);
    }

    public void updateViews(GameInfoWrapper game, Integer views){
        redisUtil.zIncr(RANK_VIEWS, game.getGameInfo().getGameId(), -1);
    }









}

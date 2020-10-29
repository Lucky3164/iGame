package com.igame.service.impl;

import com.alibaba.fastjson.JSON;
import com.igame.entity.GameInfo;
import com.igame.entity.GamePlatform;
import com.igame.entity.GameScore;
import com.igame.entity.GameTag;
import com.igame.entity.wrapper.GameInfoWrapper;
import com.igame.mapper.*;
import com.igame.mapper.wrapper.GameInfoWrapperMapper;
import com.igame.service.GameInfoService;
import com.igame.utils.RankListUtil;
import com.igame.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-11 17:43
 */
@Service
public class GameInfoServiceImpl implements GameInfoService {

    @Resource
    private GameInfoWrapperMapper gameInfoWrapperMapper;
    @Resource
    private GameInfoMapper gameInfoMapper;
    @Resource
    private GameTagMapper gameTagMapper;
    @Resource
    private GameScoreMapper gameScoreMapper;
    @Resource
    private GamePlatformMapper gamePlatformMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<GameInfoWrapper> selectByTagId(Integer tagId) {
        List<GameInfoWrapper> games = gameInfoWrapperMapper.selectByTagId(tagId);
        for (GameInfoWrapper game : games) {
            game.setViews(-redisUtil.zScore(RankListUtil.RANK_VIEWS, game.getGameInfo().getGameId()).intValue());
        }
        return games;
    }

    @Override
    public List<GameInfoWrapper> selectByTypeId(Integer typeId) {
        return gameInfoWrapperMapper.selectByTypeId(typeId);
    }

    @Override
    public GameInfoWrapper selectByGameId(Integer gameId) {
//        GameInfoWrapper game = readCache(gameId);
//        if(null != game){
//            return game;
//        }
        GameInfoWrapper game;
        game = gameInfoWrapperMapper.selectByGameId(gameId);
        game.setViews(-redisUtil.zScore(RankListUtil.RANK_VIEWS, gameId).intValue());
//        cacheGame(gameId, game);
        return game;
    }

    @Override
    public List<GameInfoWrapper> selectAll() {
        return gameInfoWrapperMapper.selectAll();
    }

    @Override
    public List<GameInfoWrapper> selectByDate(Integer platId, Integer year, Integer month) {
        return gameInfoWrapperMapper.selectByDate(platId, year, month);
    }

    @Override
    public List<GameInfoWrapper> selectRelease(Boolean release, Integer platId) {
        return gameInfoWrapperMapper.selectRelease(release, platId);
    }

    @Override
    public List<GameInfoWrapper> rankByViews() {
        List<GameInfoWrapper> RANK_VIEWS = gameInfoWrapperMapper.selectRankByViews();
//        for (GameInfoWrapper game : RANK_VIEWS) {
//            cacheGame(game.getGameInfo().getGameId(), game);
//        }
        return RANK_VIEWS;
    }

    @Override
    public void saveGameInfo(GameInfoWrapper gameInfo) {
        if(gameInfo.getGameInfo().getGameId() == null){
            gameInfoMapper.insert(gameInfo.getGameInfo());

        }else{
            gameInfoMapper.updateByPrimaryKey(gameInfo.getGameInfo());
        }
    }

    @Override
    public void delCacheByGid(Integer gid) {
        redisUtil.hDel("game_" + gid);
    }

    private void cacheGame(Integer id, GameInfoWrapper game){
        String key = "game_" + id;
        redisUtil.hSet(key, "info", JSON.toJSONString(game.getGameInfo()));
        List<GamePlatform> plats = new ArrayList<>();
        for (Map.Entry<Integer, GamePlatform> entry : game.getGamePlatformMap().entrySet()) {
            plats.add(entry.getValue());
        }
        redisUtil.hSet(key, "plats", JSON.toJSONString(plats));
        redisUtil.hSet(key, "tags", JSON.toJSONString(game.getTags()));
        redisUtil.hSet(key, "scores", JSON.toJSONString(game.getScores()));

    }

    private GameInfoWrapper readCache(Integer id){
        String key = "game_" + id;
        GameInfoWrapper game = null;
        Map<Object, Object> map = redisUtil.hGetAll(key);
        if(!map.isEmpty()){
            game = new GameInfoWrapper();
            game.setGameInfo(JSON.parseObject(redisUtil.hGet(key, "info"), GameInfo.class));
            game.setGamePlatformMap(zSetJsonArray(key, "plats", GamePlatform.class));
            game.setScores(zSetJsonArray(key, "scores", GameScore.class));
            game.setTags(zSetJsonArray(key, "tags", GameTag.class));

            game.setViews(-(redisUtil.zScore(RankListUtil.RANK_VIEWS, id)).intValue());
        }
        return game;
    }

    private <T> List<T> zSetJsonArray(String key, String field, Class<T> clazz){
        ArrayList plats = JSON.parseObject(redisUtil.hGet(key, field), ArrayList.class);
        ArrayList<T> platforms = new ArrayList<>();
        for (Object plat : plats) {
            platforms.add(JSON.parseObject(JSON.toJSONString(plat), clazz));
        }
        return platforms;
    }

}

package com.igame.service;

import com.igame.entity.GameScore;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-17 22:13
 */
public interface ScoreService {

    default int insertScore(Integer gid, Integer uid, Float score){return 0;}

    default List<GameScore> selectScoreByGid(Integer gid){return null;}

    default GameScore selectScoreByGidUid(Integer gid, Integer uid){return  null;}


}

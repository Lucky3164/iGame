package com.igame.service;

import com.igame.entity.GameInfo;
import com.igame.entity.wrapper.GameInfoWrapper;

import java.util.Date;
import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-11 17:43
 */
public interface GameInfoService {

    default List<GameInfoWrapper> selectById(Integer gameId, Integer tagId, Integer typeId){return null;}

    default List<GameInfoWrapper> selectByTagId(Integer tagId){return null;}

    default List<GameInfoWrapper> selectByTypeId(Integer typeId){return null;}

    default GameInfoWrapper selectByGameId(Integer gameId){return null;}

    default List<GameInfoWrapper> selectAll(){return null;}

    default List<GameInfoWrapper> selectByDate(Integer platId, Integer year, Integer month){return null;}

    default List<GameInfoWrapper> selectRelease(Boolean release, Integer platId){return null;}

    default List<GameInfoWrapper> rankByViews(){return null;}

    default void delCacheByGid(Integer gid){}

    default List<GameInfoWrapper> rankByScore(){return null;}

    default void countViews(Integer id){}

    default void saveGameInfo(GameInfoWrapper gameInfo){}


}

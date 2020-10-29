package com.igame.mapper.wrapper;

import com.igame.entity.wrapper.GameInfoWrapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-11 18:55
 */

public interface GameInfoWrapperMapper {

    GameInfoWrapper selectByGameId(Integer gameId);

    List<GameInfoWrapper> selectAll();

    List<GameInfoWrapper> selectByDate(Integer platId, Integer year, Integer month);

    List<GameInfoWrapper> selectRelease(Boolean release, Integer platId);

    List<GameInfoWrapper> selectRankByViews();

    List<GameInfoWrapper> selectByTagId(Integer tagId);

    List<GameInfoWrapper> selectByTypeId(Integer typeId);
}

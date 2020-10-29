package com.igame.mapper;

import com.igame.entity.GamePlatform;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface GamePlatformMapper {
    int insert(GamePlatform record);

    List<GamePlatform> selectAll();

    @MapKey("platformId")
    Map<Integer, GamePlatform> selectByGameId(Integer GameId);
}
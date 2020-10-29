package com.igame.mapper;

import com.igame.entity.GameInfo;
import java.util.List;

public interface GameInfoMapper {
    int deleteByPrimaryKey(Integer gameId);

    int insert(GameInfo record);

    GameInfo selectByPrimaryKey(Integer gameId);

    List<GameInfo> selectAll();

    int updateByPrimaryKey(GameInfo record);
}
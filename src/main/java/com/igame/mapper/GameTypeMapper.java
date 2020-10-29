package com.igame.mapper;

import com.igame.entity.GameType;
import java.util.List;

public interface GameTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(GameType record);

    GameType selectByPrimaryKey(Integer typeId);

    List<GameType> selectAll();

    int updateByPrimaryKey(GameType record);
}
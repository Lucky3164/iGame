package com.igame.mapper;

import com.igame.entity.GameTag;
import java.util.List;

public interface GameTagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(GameTag record);

    GameTag selectByPrimaryKey(Integer tagId);

    List<GameTag> selectAll();

    int updateByPrimaryKey(GameTag record);

    List<GameTag> selectByGameId(Integer gameId);
}
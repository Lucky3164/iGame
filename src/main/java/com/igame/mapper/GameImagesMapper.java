package com.igame.mapper;

import com.igame.entity.GameImages;
import java.util.List;

public interface GameImagesMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(GameImages record);

    GameImages selectByPrimaryKey(Integer imageId);

    List<GameImages> selectAll();

    int updateByPrimaryKey(GameImages record);

    List<GameImages> selectByGameId(Integer gameId);
}
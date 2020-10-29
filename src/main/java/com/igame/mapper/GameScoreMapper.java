package com.igame.mapper;

import com.igame.entity.GameScore;
import java.util.List;

public interface GameScoreMapper {
    int deleteByPrimaryKey(Integer scoreId);

    int insert(GameScore record);

    GameScore selectByPrimaryKey(Integer scoreId);

    List<GameScore> selectAll();

    int updateByPrimaryKey(GameScore record);

    List<GameScore> selectDynamic(GameScore gameScore);

    List<GameScore> selectByGameId(Integer gameId);


}
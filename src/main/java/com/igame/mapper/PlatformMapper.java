package com.igame.mapper;

import com.igame.entity.Platform;
import java.util.List;

public interface PlatformMapper {
    int deleteByPrimaryKey(Integer platformId);

    int insert(Platform record);

    Platform selectByPrimaryKey(Integer platformId);

    List<Platform> selectAll();

    int updateByPrimaryKey(Platform record);
}
package com.igame.service;

import com.igame.entity.Platform;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-13 20:30
 */
public interface PlatformService {
    default List<Platform> selectAll(){return null;}
}

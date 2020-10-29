package com.igame.service;

import com.igame.entity.GameImages;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-15 8:29
 */
public interface GamePicService {

    default List<GameImages> selectByGameId(Integer gameId){return null;}

}

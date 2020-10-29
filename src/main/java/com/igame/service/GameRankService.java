package com.igame.service;

import com.igame.entity.wrapper.GameInfoWrapper;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-24 11:05
 */
public interface GameRankService {

    default List<GameInfoWrapper> getRankMain(){return null;}


}

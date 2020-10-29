package com.igame.service.impl;

import com.igame.entity.wrapper.GameInfoWrapper;
import com.igame.mapper.wrapper.GameInfoWrapperMapper;
import com.igame.service.GameRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-24 11:05
 */
@Service
public class GameRankServiceImpl implements GameRankService {

    @Resource
    GameInfoWrapperMapper gameInfoWrapperMapper;

    @Override
    public List<GameInfoWrapper> getRankMain() {



        return null;
    }
}

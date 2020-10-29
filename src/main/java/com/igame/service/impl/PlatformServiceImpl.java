package com.igame.service.impl;

import com.igame.entity.Platform;
import com.igame.mapper.PlatformMapper;
import com.igame.service.PlatformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-13 20:31
 */
@Service
public class PlatformServiceImpl implements PlatformService {

    @Resource
    PlatformMapper platformMapper;

    @Override
    public List<Platform> selectAll() {
        return platformMapper.selectAll();
    }
}

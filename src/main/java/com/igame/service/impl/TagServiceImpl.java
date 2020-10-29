package com.igame.service.impl;

import com.igame.entity.GameTag;
import com.igame.mapper.GameTagMapper;
import com.igame.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-14 16:00
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private GameTagMapper gameTagMapper;

    @Override
    public GameTag selectTagByTagId(Integer tagId) {
        return gameTagMapper.selectByPrimaryKey(tagId);
    }

    @Override
    public List<GameTag> selectAllTag() {
        return gameTagMapper.selectAll();
    }
}

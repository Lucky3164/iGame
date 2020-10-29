package com.igame.service;

import com.igame.entity.GameTag;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-14 15:59
 */
public interface TagService {

    default GameTag selectTagByTagId(Integer tagId){return null;}

    default List<GameTag> selectAllTag(){return null;}
}

package com.igame.service.impl;

import com.igame.entity.User;
import com.igame.mapper.UserMapper;
import com.igame.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-09 8:38
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserMapper userMapper;

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}

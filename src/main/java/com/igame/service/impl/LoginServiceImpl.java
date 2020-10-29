package com.igame.service.impl;

import com.igame.entity.Msg;
import com.igame.entity.User;
import com.igame.mapper.UserMapper;
import com.igame.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-09 8:37
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getLoginUserByPhoneNumber(String phoneNumber) {
        User user = userMapper.selectByPhoneNumber(phoneNumber);
        return user;
    }

    @Override
    public int register(User user) {
        return userMapper.insert(user);
    }
}

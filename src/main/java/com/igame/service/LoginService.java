package com.igame.service;

import com.igame.entity.Msg;
import com.igame.entity.User;
import com.igame.mapper.UserMapper;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-09 8:37
 */
public interface LoginService {

    default User getLoginUserByPhoneNumber(String phoneNumber){return null;}

    default int register(User user){return 0;}

}

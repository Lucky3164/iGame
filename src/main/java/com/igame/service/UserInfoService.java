package com.igame.service;

import com.igame.entity.User;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-09 8:37
 */
public interface UserInfoService {

    default int updateUserInfo(User user){return 0;}

}

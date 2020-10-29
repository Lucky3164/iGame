package com.igame.utils;

import com.igame.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-15 20:18
 */
public class LoginUtil {

    public static User getLoginUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

}

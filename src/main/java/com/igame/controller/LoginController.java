package com.igame.controller;

import com.igame.entity.Comment;
import com.igame.entity.Msg;
import com.igame.entity.User;
import com.igame.entity.VerifyCode;
import com.igame.service.LoginService;
import com.igame.utils.MD5Util;
import com.igame.utils.VerifyCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-07 15:36
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    @ResponseBody
    public Msg login(String username, String password, String autologin,
                     HttpServletRequest request,
                     Map<String, Object> map) {

        Subject currentUser = SecurityUtils.getSubject();
        User user = null;
        Msg msg = null;
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe("1".equals(autologin));
            try {
                currentUser.login(token);
                user = (User) currentUser.getPrincipal();
                request.getSession().setAttribute("loginUser", user);
                msg = Msg.success("登陆成功");
            } catch (UnknownAccountException e) {
                System.out.println("用户名不存在");
                msg = Msg.fail("用户名不存在").add("usernameError", "用户名不存在");
                map.put("loginTips", msg);
            } catch (AuthenticationException e) {
                System.out.println("密码错误");
//                e.printStackTrace();
                msg = Msg.fail("密码错误").add("passwordError", "密码错误");
                map.put("loginTips", msg);
            }
        }
        return msg;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public Msg register(User user, HttpServletRequest request) {
        Msg msg = null;
        String psw = MD5Util.toMd5(user.getPassword(), user.getUserName(), 5);
//        user.setPassword(psw);
        if (!VerifyCodeUtil.checkVerifyCode(request)) {
            return Msg.fail("验证码有误");
        }
        int resultCount = loginService.register(user);
        if (resultCount > 0) {
            msg = Msg.success("注册成功");
        } else {
            msg = Msg.fail("注册失败");
        }
        return msg;
    }


//    @PostMapping("/register")
//    public String register(String phoneNumber, String userName,
//                           String password){
//        int resultCount = loginService.register(phoneNumber, userName, password);
//        return "redirect:/login";
//    }


}

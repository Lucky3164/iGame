package com.igame.controller;

import com.igame.entity.Msg;
import com.igame.entity.User;
import com.igame.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-08 15:17
 */
@Controller
@RequestMapping("/user")
@SessionAttributes(names = {"loginUser"})
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;



    @GetMapping("/comment")
    public String toCommentPage(){

        return "user/comment";
    }

    @GetMapping("/personalInfo")
    public String toPersonalInfo(){

        return "user/userInfo";
    }

    @GetMapping("/updatePassword")
    public String toUpdPassword(){
        return "user/updPassword";
    }

    @PostMapping("/updateSetting")
    @ResponseBody
    public Msg updateSetting(@ModelAttribute("loginUser") User user,
                             @RequestParam(value = "headPhoto", required = false) MultipartFile file){
        if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            String filePath = "D:\\WorkSpaces\\IDEA Project\\Lucky-Project\\iGameDemo\\target\\classes\\static\\image\\headPhoto\\"; // 上传后的路径
            //String filePath = "/opt/LuckyProject/iGame/image/headPhoto/"
            fileName = UUID.randomUUID() + suffixName; // 新文件名
            System.out.println(filePath + fileName);
            File dest = new File(filePath + fileName);
            System.out.println("dest AbsolutePath : " + dest.getAbsolutePath());
            System.out.println("dest Path : " + dest.getPath());
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String filename = "/image/headPhoto/" + fileName;
            user.sethImgPath(filename);
        }
        userInfoService.updateUserInfo(user);
        return Msg.success("修改成功");
    }

    @PostMapping("/updatePassword")
    @ResponseBody
    public Msg updatePassword(@ModelAttribute("loginUser")User user,
                              @RequestParam Map<String, Object> map){
        String oldPassword = (String) map.get("oldpasswd");
        if(user.getPassword().equals(oldPassword)){
            user.setPassword((String) map.get("newpassword"));
            return Msg.success("修改成功，请重新登陆");
        }

        return Msg.fail("原密码输入有误");
    }

}

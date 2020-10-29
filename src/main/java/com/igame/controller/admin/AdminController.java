package com.igame.controller.admin;

import com.igame.entity.wrapper.GameInfoWrapper;
import com.igame.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-19 8:57
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    GameInfoService gameInfoService;

    @GetMapping("/gameTable")
    public String toGameTablePage(Map<String, Object> map){

        map.put("games", gameInfoService.selectAll());

        return "admin/game/gTablePage";
    }

    @GetMapping("/editarticle")
    public String toEditArticlePage(){

        return "admin/article/article-editor";
    }

}

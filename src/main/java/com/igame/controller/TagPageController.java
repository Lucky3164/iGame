package com.igame.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.igame.entity.GameTag;
import com.igame.entity.wrapper.GameInfoWrapper;
import com.igame.service.GameInfoService;
import com.igame.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-14 10:54
 */
@Controller
@RequestMapping("/tag")
public class TagPageController {

    @Autowired
    GameInfoService gameInfoService;
    @Autowired
    TagService tagService;

    @GetMapping(value = {
            "/",
            "",
            "/{tagId}",
            "/{tagId}/{pn}"
    })
    public String toTagPage(@PathVariable( required = false, name = "tagId")Integer tagId,
                            @PathVariable(required = false, name = "pn")Integer pn,
                            Map<String, Object> map){
        if (tagId == null) tagId = 100;
        GameTag gameTag = tagService.selectTagByTagId(tagId);
        List<GameTag> gameTags = tagService.selectAllTag();
        map.put("gameTag", gameTag);
        map.put("gameTags", gameTags);

        if(pn == null) pn = 1;
        PageHelper.startPage(pn, 10);
        List<GameInfoWrapper> games = gameInfoService.selectByTagId(tagId);
        PageInfo<GameInfoWrapper> pageInfo = new PageInfo<>(games, 5);
        map.put("pageInfo", pageInfo);
        map.put("pageURL", "/tag/" + tagId + "/");
        return "index62";
    }

}

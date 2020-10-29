package com.igame.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.igame.entity.Article;
import com.igame.entity.Platform;
import com.igame.entity.wrapper.GameInfoWrapper;
import com.igame.mapper.wrapper.GameInfoWrapperMapper;
import com.igame.mapper.PlatformMapper;
import com.igame.service.ArticleService;
import com.igame.service.GameInfoService;
import com.igame.service.PlatformService;
import com.igame.utils.RankListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-13 14:19
 */
@Controller
public class PageController {

    @Autowired
    GameInfoService gameInfoService;
    @Autowired
    PlatformService platformService;
    @Autowired
    ArticleService articleService;
    @Autowired
    RankListUtil rankListUtil;

    @GetMapping("/")
    public String toHomePage(Map<String, Object> map){

        PageHelper.startPage(1, 5);
        List<GameInfoWrapper> unRelease = gameInfoService.selectRelease(false, null);
        PageInfo<GameInfoWrapper> page = new PageInfo<>(unRelease, 1);
        map.put("unReleaseGame", page.getList());
        List<Article> articles = articleService.selectAll();
        map.put("articles", articles);
        List<GameInfoWrapper> topN = rankListUtil.getTopN(15);
        map.put("top10", topN);

        return "index";
    }

    @GetMapping(value = {
            "/release",
            "/release/{pd}",
            "/release/{pd}/{pn}"})
    public String toReleasePage(Map<String, Object> map,
                                @PathVariable(required = false) String pd,
                                @PathVariable(required = false)Integer pn){

        List<Platform> platforms = platformService.selectAll();
        map.put("platforms", platforms);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        String format = simpleDateFormat.format(new Date(System.currentTimeMillis()));

        if(pd == null) pd = "101" + format;
        Integer platNow = Integer.valueOf(pd.substring(0, 3));
        Integer year = Integer.valueOf(pd.substring(3, 7));
        Integer month = Integer.valueOf(pd.substring(7));
        map.put("platNow", platNow);
        map.put("year", year);
        map.put("month", month);

        //分页
        if(pn == null) pn = 1;
        PageHelper.startPage(pn, 10);
        List<GameInfoWrapper> gameInfoWrappers = gameInfoService.selectByDate(platNow, year, month);
        PageInfo<GameInfoWrapper> pageInfo = new PageInfo<>(gameInfoWrappers, 5);
        map.put("games", pageInfo);
        map.put("pageUrl", "/release/" + pd);

        return "index56";
    }

    @GetMapping(value = {
            "/article",
            "/article/{pn}"
    })
    public String toArticleIndexPage(Map<String, Object> map,
                                     @PathVariable(required = false) Integer pn){

        if(pn == null) pn = 1;
        PageHelper.startPage(pn, 3);
        PageInfo<Article> pageInfo = new PageInfo<>(articleService.selectAll(), 5);
        map.put("page", pageInfo);
        map.put("pageUrl", "/article");

        return "articleIndex";
    }

    @GetMapping("/article/details/{aid}")
    public String toArticleDetails(@PathVariable Integer aid,
                                   Map<String, Object> map){
        Article article = articleService.selectByPrimaryKey(aid);
        map.put("article", article);
        return "articleDetails";
    }

    @GetMapping("/so")
    public String searchPage(String keywords,
                             Integer type,
                             Map<String, Object> map){

        switch (type){
            case 1:
            case 2:
            default:
        }

        return "so";
    }

    @GetMapping("/save")
    public String save(){



        return "forward:/";
    }

}

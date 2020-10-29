package com.igame.controller;

import com.igame.entity.*;
import com.igame.entity.wrapper.CommentWrapper;
import com.igame.entity.wrapper.GameInfoWrapper;
import com.igame.mapper.CommentMapper;
import com.igame.mapper.wrapper.CommentWrapperMapper;
import com.igame.mapper.GamePlatformMapper;
import com.igame.service.GameInfoService;
import com.igame.service.GamePicService;
import com.igame.utils.RankListUtil;
import com.igame.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-08 11:21
 */
@RestController
@RequestMapping("/testController")
public class testController {

    @Resource
    CommentMapper commentMapper;
    @Resource
    GamePlatformMapper gamePlatformMapper;
    @Autowired
    GameInfoService gameInfoService;
    @Resource
    CommentWrapperMapper commentWrapperMapper;
    @Autowired
    GamePicService gamePicService;
    @Autowired
    RankListUtil rankListUtil;

    @RequestMapping("/testCommentMapper/{id}")
    public Comment testCommentMapper(@PathVariable("id") Integer id){
        Comment comment = null;

        comment = commentMapper.selectByPrimaryKey(id);

        return comment;
    }

    @RequestMapping("/testCommentMapperSelectAll")
    public List<Comment> testCommentMapperSelectAll(){
        return commentMapper.selectAll();
    }

    @RequestMapping("/testPlatformMapper/{id}")
    public Map<Integer, GamePlatform> testPlatformMapper(@PathVariable("id")Integer id){
        return gamePlatformMapper.selectByGameId(id);
    }

    @RequestMapping("/testCommentWrapperMapper/{id}")
    public List<CommentWrapper> testCommentWrapperMapper(@PathVariable("id")Integer id){
        return commentWrapperMapper.selectAllParentByArticleId(id);
    }

    @RequestMapping("/testCache/{id}")
    public List<GameImages> testCache(@PathVariable("id")Integer id){
        return gamePicService.selectByGameId(id);
    }

    @RequestMapping("/testRank")
    public List<GameInfoWrapper> testRank(){
        return rankListUtil.getTopN(10);
    }
}

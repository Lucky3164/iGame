package com.igame.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.igame.entity.Msg;
import com.igame.entity.User;
import com.igame.entity.wrapper.CommentWrapper;
import com.igame.service.CommentService;
import com.igame.utils.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-15 9:07
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/list/game/{id}")
    @ResponseBody
    public Msg getCommentList(@PathVariable("id")Integer gameId,
                                               Integer pn,
                                               Integer order,
                                               Integer pageSize){
        PageHelper.startPage(pn, pageSize);
        List<CommentWrapper> gameComments = commentService.selectAllByGameId(gameId, order);
        PageInfo<CommentWrapper> pageInfo = new PageInfo<>(gameComments, 5);
        Msg msg = new Msg("200", "");
        int ctCount = commentService.selectCommentCountByGameId(gameId);
        msg.add("ctPage", pageInfo).add("ctCount", ctCount);
        return msg;
    }

    @PostMapping("/reply/{gameId}")
    public Msg replyCommentFromGame(@PathVariable("gameId")Integer gameId,
                                    String content,
                                    Integer parentId,
                                    Integer replyId){
        User loginUser = LoginUtil.getLoginUser();
        if(loginUser == null){
            return new Msg("409", "请先登陆");
        }
        Map<String, Object> para = new HashMap<>();

        para.put("gameId", gameId);
        para.put("content", content);
        if(parentId == null){
            parentId =  commentService.selectLastCommentId() + 1;
        }
        para.put("parentId", parentId);
        para.put("replyId", replyId);
        para.put("uid", loginUser.getUserId());
        int result = commentService.saveCommentFromGame(para);

        return new Msg("200", "Success");
    }



}

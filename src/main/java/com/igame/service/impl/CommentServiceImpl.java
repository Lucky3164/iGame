package com.igame.service.impl;

import com.igame.entity.Comment;
import com.igame.entity.wrapper.CommentWrapper;
import com.igame.mapper.CommentMapper;
import com.igame.mapper.wrapper.CommentWrapperMapper;
import com.igame.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-15 9:08
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentWrapperMapper commentWrapperMapper;
    @Resource
    CommentMapper commentMapper;

    @Override
    public List<CommentWrapper> selectAllByGameId(Integer gameId, Integer order) {
        return commentWrapperMapper.selectAllParentByGameId(gameId, order);
    }

    @Override
    public int saveCommentFromGame(Map<String, Object> para) {
        Comment comment = new Comment();
        comment.setGameId((Integer) para.get("gameId"));
        comment.setUserId((Integer) para.get("uid"));
        comment.setContent((String) para.get("content"));
        comment.setParentId((Integer) para.get("parentId"));
        comment.setReplyId((Integer) para.get("replyId"));
        System.out.println(comment);
        return commentMapper.insert(comment);
    }

    @Override
    public int selectLastCommentId() {
        Integer cid = commentMapper.selectLastCommentId();
        return cid == null ? 0 : cid;
    }

    @Override
    public int selectCommentCountByGameId(Integer gameId) {
        Integer cid = commentMapper.selectCommentCountByGameId(gameId);
        return cid == null ? 0 : cid;
    }
}

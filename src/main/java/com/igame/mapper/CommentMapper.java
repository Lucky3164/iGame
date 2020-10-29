package com.igame.mapper;

import com.igame.entity.Comment;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);

//    List<Comment> selectByGameId(Integer gameId);

//    List<List<Comment>> selectByArticleId(Integer articleId);

    List<Comment> selectByUserId(Integer userId);

    List<Comment> selectByParentId(Integer parentId);

    Comment selectByReplyId(Integer replyId);

    Integer selectLastCommentId();

    Integer selectCommentCountByGameId(Integer gameId);
}
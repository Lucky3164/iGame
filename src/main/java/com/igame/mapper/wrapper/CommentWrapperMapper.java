package com.igame.mapper.wrapper;

import com.igame.entity.wrapper.CommentWrapper;
import com.igame.entity.wrapper.GameInfoWrapper;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-11 18:55
 */

public interface CommentWrapperMapper {

    List<CommentWrapper> selectByUserId(Integer userId);

    List<CommentWrapper> selectByGameId(Integer gameId);

    List<CommentWrapper> selectByArticleId(Integer articleId);

    List<CommentWrapper> selectAllParentByGameId(Integer gameId, Integer order);

    List<CommentWrapper> selectAllParentByArticleId(Integer articleId);

}

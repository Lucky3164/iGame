package com.igame.service;

import com.igame.entity.wrapper.CommentWrapper;

import java.util.List;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-15 9:07
 */
public interface CommentService {

    default List<CommentWrapper> selectAllByGameId(Integer gameId, Integer order){return null;}

    default int saveCommentFromGame(Map<String, Object> para){return 0;}

    default int selectLastCommentId(){return 0;}

    default int selectCommentCountByGameId(Integer gameId){return 0;}

}

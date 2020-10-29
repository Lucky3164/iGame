package com.igame.service;

import com.igame.entity.Article;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-19 10:52
 */
public interface ArticleService {

    default int insert(Article record){return 0;}

    default Article selectByPrimaryKey(Integer articleId){return null;}

    default List<Article> selectAll(){return null;}
}

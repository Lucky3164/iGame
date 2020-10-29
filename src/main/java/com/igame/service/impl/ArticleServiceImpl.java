package com.igame.service.impl;

import com.igame.entity.Article;
import com.igame.mapper.ArticleMapper;
import com.igame.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-19 10:52
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleMapper articleMapper;

    @Override
    public int insert(Article record) {
        return 0;
    }

    @Override
    public Article selectByPrimaryKey(Integer articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public List<Article> selectAll() {
        return articleMapper.selectAll();
    }
}

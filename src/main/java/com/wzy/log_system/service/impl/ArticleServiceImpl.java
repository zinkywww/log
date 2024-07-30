package com.wzy.log_system.service.impl;

import com.wzy.log_system.entity.Article;
import com.wzy.log_system.mapper.ArticleMapper;
import com.wzy.log_system.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getAll() {
        return articleMapper.getAll();
    }

    @Override
    public void add(Article article) {
        articleMapper.addArticle(article);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.deleteArticleById(id);
        String key = "article:" + id;
        redisTemplate.delete(key);
    }

    @Override
    public Article getById(Integer id) {
        Object articleCache = redisTemplate.opsForValue().get("article:" + id);
        if (articleCache != null) {
            return (Article) articleCache;
        }
        //缓存没有，查数据库更新缓存
        Article article = articleMapper.getArticleById(id);
        redisTemplate.opsForValue().set("article:" + id, article);

        return article;
    }

    @Override
    public void update(Article article) {
        articleMapper.updateArticle(article);
        //删除缓存
        String key = "article:" + article.getId();
        redisTemplate.delete(key);
    }

    @Override
    public List<Article> getByUserId(Integer userId) {
        Object articleCache = redisTemplate.opsForValue().get("articleList:" + userId);
        if (articleCache != null) {
            log.info("查询缓存成功");
            return (List<Article>) articleCache;
        }
        List<Article> articleList = articleMapper.getArticleByUserId(userId);
        redisTemplate.opsForValue().set("articleList:" + userId, articleList);
        return articleList;
    }

}

package com.wzy.log_system.service.impl;

import com.wzy.log_system.entity.Article;
import com.wzy.log_system.mapper.ArticleMapper;
import com.wzy.log_system.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
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
    }

    @Override
    public Article getById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public void update(Article article) {
        articleMapper.updateArticle(article);
    }
}

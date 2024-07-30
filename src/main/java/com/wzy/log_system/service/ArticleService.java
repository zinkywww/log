package com.wzy.log_system.service;

import com.wzy.log_system.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();

    void add(Article article);

    void delete(Integer id);

    Article getById(Integer id);

    void update(Article article);

    List<Article> getByUserId(Integer id);
}

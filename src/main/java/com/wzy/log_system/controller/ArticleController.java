package com.wzy.log_system.controller;

import com.wzy.log_system.entity.Article;
import com.wzy.log_system.entity.User;
import com.wzy.log_system.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/article")
public class ArticleController {
    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping()
    public List<Article> getAll(int userId) {
        return articleMapper.getArticleByUser(userId);
    }



    @PostMapping
    public void update(@RequestBody Article article) {
        articleMapper.updateArticle(article);
    }


}

package com.wzy.log_system.controller;

import com.wzy.log_system.entity.Article;
import com.wzy.log_system.entity.Result;
import com.wzy.log_system.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public Result getAll() {
        log.info("获取所有文章");
        return Result.success(articleService.getAll());
    }

    @PostMapping("/articles")
    public Result addArticle(@RequestBody Article article) {
        log.info("增加文章");
        articleService.add(article);
        return Result.success();
    }

    @DeleteMapping("/articles/{id}")
    public Result deleteArticle(@PathVariable Integer id) {
        log.info("根据id删除文章");
        articleService.delete(id);
        return Result.success();
    }

    @GetMapping("/articles/{id}")
    public Result getArticleById(@PathVariable Integer id) {
        log.info("通过id获取文章");
        Article article = articleService.getById(id);
        return Result.success(article);
    }

    @PutMapping("/articles")
    public Result updateArticleById(@RequestBody Article article) {
        log.info("修改查询到的文章");
        articleService.update(article);
        return Result.success();
    }





}

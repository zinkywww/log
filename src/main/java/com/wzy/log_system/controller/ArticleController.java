package com.wzy.log_system.controller;

import com.alibaba.fastjson.JSONObject;
import com.wzy.log_system.entity.Article;
import com.wzy.log_system.entity.Result;
import com.wzy.log_system.entity.User;
import com.wzy.log_system.service.ArticleService;
import com.wzy.log_system.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/articles")
    public Result getAll(HttpServletRequest request) {
        log.info("获取所有文章");
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJwt(token);
        List<Article> list = articleService.getByUserId((Integer)claims.get("id"));
        return Result.success(list);
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
        //查询redis缓存

        String articleCache = stringRedisTemplate.opsForValue().get(""+id);
        if(articleCache !=null){
            return Result.success(articleCache);
        }

        //未查询到则查数据库，并更新redis
        Article article = articleService.getById(id);
        String articleJson  =JSONObject.toJSONString(article);
        stringRedisTemplate.opsForValue().set(""+id, articleJson);
        return Result.success(article);
    }

    @PutMapping("/articles")
    public Result updateArticleById(@RequestBody Article article) {
        log.info("修改查询到的文章");
        articleService.update(article);
        return Result.success();
    }

}

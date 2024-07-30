package com.wzy.log_system;


import com.wzy.log_system.entity.Article;
import com.wzy.log_system.mapper.ArticleMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class SpringBootRedisTests {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private ArticleMapper articleMapper ;


    @Test
    public void test() {
        System.out.println(redisTemplate);
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        //set get setnx setex setnx
        ops.set("key1", "value1");
        ops.set("code","1234",3, TimeUnit.MINUTES);
        ops.setIfAbsent("key2", "value2");
        ops.setIfAbsent("key2", "value3");

    }

    @Test
    public void test1() {
        Object articleCache = redisTemplate.opsForValue().get("articleList:" + 4);
        if (articleCache != null) {
            System.out.println((List<Article>) articleCache);
            return ;
        }
        List<Article> articleList = articleMapper.getArticleByUserId(4);
        System.out.println(articleList);
        redisTemplate.opsForValue().set("articleList:" + 4, articleList);
    }
}

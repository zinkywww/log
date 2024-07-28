package com.wzy.log_system;

import com.wzy.log_system.entity.Article;
import com.wzy.log_system.entity.User;
import com.wzy.log_system.mapper.ArticleMapper;
import com.wzy.log_system.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogSystemApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Resource
    private ArticleMapper articleMapper;


    @Test
    void contextLoads() {
        System.out.println(articleMapper.getArticleById(1).toString());
//        studentMapper.getStudentById(1);
//        articleMapper.getArticleById(1);
        System.out.println("hello world");
    }

    @Test
    void testAddArticle(){
        Article article = new Article();
        article.setTitle("Python");
        article.setContent("python入门到放弃..");
        int i = articleMapper.addArticle(article);
        System.out.println(i);
    }

    @Test
    void testUpdateArticle(){
        Article article = new Article();
        article.setId(3);
        article.setTitle("Python");
        article.setContent("python入门到精通..");
        int i = articleMapper.updateArticle(article);
        System.out.println(i);
    }
    @Test
    void deleteArticle(){
        int i = articleMapper.deleteArticleById(4);
        System.out.println(i);
    }
    @Test
    void testUser(){
        User user = userMapper.getUserByUserId("111");
        System.out.println(user);
        user.setPassword("222");
        userMapper.updateUser(user);
        System.out.println(user);
        userMapper.deleteUser(user);




    }



}

package com.wzy.log_system.mapper;


import com.wzy.log_system.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from t_article")
    List<Article> getAll();

    @Insert("insert into t_article values (null,#{user},#{title},#{content})")
    int addArticle(Article article);

    @Delete("delete from t_article where id=#{id}")
    int deleteArticleById(int id);

    @Select("select * from t_article where id=#{id}")
    Article getArticleById(Integer id);

    @Update("update t_article set title=#{title},content=#{content} where id = #{id}")
    int updateArticle(Article article);

    @Select("select * from t_article where userId=#{userId}")
    List<Article> getArticleByUserId(Integer userId);
}

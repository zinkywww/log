package com.wzy.log_system.mapper;


import com.wzy.log_system.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    //根据id查询
    @Select("select * from t_article where id=#{id}")
    Article getArticleById(int id);

    @Select("select * from t_article where user=#{user}")
    List<Article> getArticleByUser(int user);


    @Insert("insert into t_article values (null,#{user},#{title},#{content})")
    int addArticle(Article article);

    @Update("update t_article set title=#{title},content=#{content} where id = #{id}")
    int updateArticle(Article article);

    @Delete("delete from t_article where id=#{id}")
    int deleteArticleById(int id);


}

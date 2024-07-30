package com.wzy.log_system.mapper;

import com.wzy.log_system.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
//    @Select("select * from t_user where userId=#{userId}")
//    User getUserByUserName(String userId);
//
//    @Select("select * from t_user where userId=#{userId}")
//    User getUser(User user);

    @Select("select * from t_user")
    List<User> getAllUsers();

    @Insert("insert into t_user values (null,#{userId},#{password})")
    void insertUser(User user);

    @Update("update t_user set userId=#{userId},password = #{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from t_user where id=#{id}")
    void deleteUser(Integer id);

    @Select("select * from t_user where username=#{username} and password=#{password}")
    User getByUsernameAndPassword(User user);

    @Select("select * from t_user where username=#{username}")
    User getByUserName(String username);
}

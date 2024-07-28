package com.wzy.log_system.controller;


import com.wzy.log_system.entity.User;
import com.wzy.log_system.mapper.UserMapper;
import com.wzy.log_system.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User result=userMapper.getUserByUserId(user.getUserId());
        if(result!=null) {
            String token = TokenUtils.getToken(user.getUserId());
            stringRedisTemplate.opsForValue().set(token, user.getUserId());
            return token;
        }
        else{
            return null;
        }
    }
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        if(userMapper.getUserByUserId(user.getUserId())!=null) {
            userMapper.insertUser(user);
            return "注册成功，请登录！";
        }else{
            return "用户已被占用！";
        }
    }









}

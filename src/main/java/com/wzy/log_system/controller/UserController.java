package com.wzy.log_system.controller;


import com.wzy.log_system.entity.Result;
import com.wzy.log_system.entity.User;
import com.wzy.log_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Result findAll(){
        log.info("查询所有用户");
        List<User> list=userService.getAll();
        return Result.success(list);
    }

    @PutMapping("/users")
    public Result addUser(@RequestBody User user){
        log.info("增加用户");
        User u = userService.getByUserName(user.getUsername());
        if(u==null){
            log.info("成功增加用户");
            userService.add(user);
            return Result.success();
        }
        log.info("用户名重复");
        return Result.error("USERNAME_EXIST");
    }

    @DeleteMapping("users/{id}")
    public Result deleteUser(@PathVariable("id") Integer id){
        log.info("根据id删除用户");
        userService.delete(id);
        return Result.success();
    }

}

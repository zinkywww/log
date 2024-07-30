package com.wzy.log_system.controller;


import com.wzy.log_system.entity.Result;
import com.wzy.log_system.entity.User;
import com.wzy.log_system.service.UserService;
import com.wzy.log_system.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("用户登录");
        User u = userService.login(user);

        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());
            String jwt = JwtUtils.genJwt(claims);
            return Result.success(jwt);
        }

        return Result.error("用户名或密码错误");
    }

}

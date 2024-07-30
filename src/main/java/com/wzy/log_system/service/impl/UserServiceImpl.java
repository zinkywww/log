package com.wzy.log_system.service.impl;

import com.wzy.log_system.entity.User;
import com.wzy.log_system.mapper.UserMapper;
import com.wzy.log_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getAll() {
        return userMapper.getAllUsers();
    }

    @Override
    public void add(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.deleteUser(id);
    }

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public User getByUserName(String username) {
        return userMapper.getByUserName(username);
    }

}

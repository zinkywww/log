package com.wzy.log_system.service;

import com.wzy.log_system.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    void add(User user);

    void delete(Integer id);

    User login(User user);

    User getByUserName(String username);
}

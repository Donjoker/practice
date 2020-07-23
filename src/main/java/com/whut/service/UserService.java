package com.whut.service;

import com.whut.bean.User;

import java.util.List;

public interface UserService {
    int login(String username,String password);

    List<User> findAll();

    void add(User user);

    void deleteById(int id);

    User selectUserById(int id);

    void update(User user);
}

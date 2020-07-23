package com.whut.dao;

import com.whut.bean.User;

import java.util.List;

public interface UserDao {
    User findByUserName(String username);

    List<User> findAll();

    void add(User user);

    void deleteById(int id);

    User selectById(int id);

    void update(User user);
}

package com.whut.service.impl;

import com.whut.bean.User;
import com.whut.dao.UserDao;
import com.whut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int login(String username, String password) {
        User user=userDao.findByUserName(username);
        if(user!=null&&user.getPassword().equals(password)){
            return user.getId();
        }
        return -1;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User selectUserById(int id) {

        return userDao.selectById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

}

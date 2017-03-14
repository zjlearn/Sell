package com.netease.service.Impl;

import com.netease.dao.UserDao;
import com.netease.meta.User;
import com.netease.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zjlearn on 2017/2/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User getUserByName(String name) {
       return  this.userDao.getUserByName(name);
    }
    public void InsertUser(User u){
        this.userDao.InsertUser(u);
    }
}

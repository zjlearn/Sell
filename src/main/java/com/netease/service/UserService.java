package com.netease.service;

import com.netease.meta.User;
import org.springframework.stereotype.Service;

/**
 * Created by zj on 2017/2/24.
 */

public interface UserService {
    public User getUserByName(String Name);
    public void InsertUser(User u);

}

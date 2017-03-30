package com.netease.dao;

import com.netease.meta.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by zj on 2017/2/15.
 */

@Repository
public interface UserDao {
    public User GetUserByid(int id);

    public User getUserByName(String Name) ;

    public void InsertUser(User u);


}

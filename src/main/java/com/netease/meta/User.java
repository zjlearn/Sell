package com.netease.meta;

import java.util.List;

/**
 * Created by zj on 2017/2/15.
 */
public class User {
    private int id;
    private String userName;
    private String password;
    //private List<Product> deal;

    public User(){
        this.id=0;
        this.userName="XXX";
        this.password="*****";
    }
    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    public User( String userName, String password) {
        this.id = 0;
        this.userName = userName;
        this.password = password;
        //this.deal=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

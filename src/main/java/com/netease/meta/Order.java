package com.netease.meta;

import java.sql.Timestamp;

/**
 * Created by zj on 2017/2/20.
 */
//订单信息
public class Order {
    private int userId;
    private int productId;
    private String photoAddress;
    private  String productName;
    private int num ;
    private float price;
    private Timestamp orderTime;

    public  Order(){
        System.out.println("in the order constructor");
    }
    public Order(int userId, int productId, int num, float price, Timestamp orderTime) {
        this.userId = userId;
        this.productId = productId;
        this.num = num;
        this.price = price;
        this.orderTime = orderTime;
    }

    public Order(int userId, int productId, String productAddress, String productName, int num, float price, Timestamp orderTime) {
        this.userId = userId;
        this.productId = productId;
        this.photoAddress = productAddress;
        this.productName = productName;
        this.num = num;
        this.price = price;
        this.orderTime = orderTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Order(int userId, int productId, int num ) {
        this.userId = userId;
        this.productId = productId;
        this.num=num;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress;
    }

    public  String toString(){
        return this.photoAddress;
    }
}

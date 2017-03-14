package com.netease.meta;

/**
 * Created by zjlearn on 2017/3/8.
 */
public class CartProduct{
    public int num;
    public float price;
    public String name;

    public CartProduct( String name,int num, float price) {
        this.num = num;
        this.price = price;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

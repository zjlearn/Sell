package com.netease.meta;

import java.util.HashMap;

/**
 * Created by zjlearn on 2017/3/6.
 */

public class Cart {

    private HashMap<String, CartProduct> products;  //放入购物车中的所有的数据

    public HashMap<String, CartProduct> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, CartProduct> products) {
        this.products = products;
    }

    public Cart(){
        products= new HashMap<String, CartProduct>();
    }

    //添加商品到购物车中
    public void addproduct(String  id, float price, String name, int num){
        if(products.containsKey(id)){
            CartProduct c= products.get(id);
            c.num += num;
            c.price=price;
            products.put(id,c);
        }else{
            CartProduct c= new CartProduct(name, num, price);
            products.put(id, c);
        }
    }
}

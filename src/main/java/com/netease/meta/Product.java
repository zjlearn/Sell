package com.netease.meta;

/**
 * Created by zj on 2017/2/17.
 */
//d
public class Product {
    private int id;
    private  String productName;  //限制在80个长度以内
    private float price;
    private int stock; //产品的存量
    private String summary; //限制在140个字符以内
    private String  detail; //限制在1000个字符以内
    private String  photoAddress; // 大小限制1MB
    private  int ownerId;   //发布者的Id

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Product(){
        this.id=0000;
        this.productName="Unknow";
        this.stock=0;
    }

    public Product( String name, int ownerIdId,  int stock,  String summary, String desc, float price, String photoAddress) {
        this.productName = name;
        this.ownerId=ownerIdId;
        this.summary = summary;
        this.detail = desc;
        this.price = price;
        this.photoAddress = photoAddress;
        this.stock=stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress;
    }
}

package com.netease.dao;

import com.netease.meta.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zj on 2017/2/23.
 */
//操作product的接口

    @Repository
public interface ProductDao {

    //通过商品的Id，读取商品
    public Product getProductById(int id);
    //insert the product info into the db
    public void insertProduct(Product product);
    //通过所有者的Id，获取已发布的product
    public List<Product> getProductByOwnerId(int id);

    public List<Product> getAllProducts();

    public List<Product> getPurchasedProducts(int id);

    public List<Product> getNotPurchasedProducts(int id);

    public boolean isPrurchased(@Param("userId") int userId,@Param("productId") int productId);

    public int getProductNum(int productId);

    //更新商品的数量
    boolean updateNum(int id, int stock);

    public void updateProduct(Product pdo);
}

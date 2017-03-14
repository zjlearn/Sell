package com.netease.service;

import com.netease.meta.Product;

import java.util.List;

/**
 * Created by zjlearn on 2017/2/27.
 */
public interface productService {

    public void insertProduct(Product product);

    public Product getProductById(int id);

    public List<Product> getProductByOwnerId(int id);
    public boolean isPrurchased(int userId, int productId);

    public void updateProduct(Product product);
}

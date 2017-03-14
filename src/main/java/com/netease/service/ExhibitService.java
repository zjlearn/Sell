package com.netease.service;

import com.netease.meta.Product;

import java.util.List;

/**
 * Created by zjlearn on 2017/2/28.
 */
public interface ExhibitService {
    public Product getProductById(int id);
    public List<Product> getAllProducts();

    public List<Product> getPurchasedProducts(int id);
    public List<Product> getNotPurchasedProducts(int id);
}

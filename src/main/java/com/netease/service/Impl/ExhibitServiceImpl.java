package com.netease.service.Impl;

import com.netease.dao.ProductDao;
import com.netease.meta.Product;
import com.netease.service.ExhibitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zjlearn on 2017/2/28.
 */

@Service
public class ExhibitServiceImpl implements ExhibitService {
    @Resource
    private ProductDao pdao;

    public Product getProductById(int id) {
        return this.pdao.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return this.pdao.getAllProducts();
    }

    public List<Product> getPurchasedProducts(int id) {
        return this.pdao.getPurchasedProducts(id);
    }

    public List<Product> getNotPurchasedProducts(int id) {
        return this.pdao.getNotPurchasedProducts(id);
    }
}

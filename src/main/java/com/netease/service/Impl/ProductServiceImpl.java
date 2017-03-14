package com.netease.service.Impl;

import com.netease.dao.ProductDao;
import com.netease.meta.Product;
import com.netease.service.productService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zjlearn on 2017/2/27.
 */
@Service
public class ProductServiceImpl implements productService {

    @Resource
    private ProductDao pdao;

    public void insertProduct(Product product) {
        this.pdao.insertProduct(product);
    }

    public Product getProductById(int id){
        return this.pdao.getProductById(id);
    }

    public List<Product> getProductByOwnerId(int id){
        return this.pdao.getProductByOwnerId(id);
    }

    public boolean isPrurchased(int userId, int productId){
        return this.pdao.isPrurchased(userId, productId);
    }

    public void updateProduct(Product product) {
        this.pdao.updateProduct(product);
    }
}

package com.netease.service.Impl;

import com.netease.dao.OrderDao;
import com.netease.dao.ProductDao;
import com.netease.meta.CartProduct;
import com.netease.meta.Order;
import com.netease.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by zjlearn on 2017/3/8.
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderdao;
    @Resource
    private ProductDao pdo;

    public boolean  createOrder(int userId, int productId, CartProduct product) {
        Order order = new Order(userId,productId, product.getNum(), product.getPrice(),new Timestamp(System.currentTimeMillis()) );
        int stockbefore=pdo.getProductNum(productId);
        if(stockbefore < product.getNum() )
            return false;
        int stock=stockbefore - product.getNum();
        System.out.println("begin to add the order");
        this.orderdao.addOrder(order);
        System.out.println("begin update the stock");
        this.pdo.updateNum(productId, stock);
        return true;
    }

    public List<Order> getOrderbyUser(int id){
        return this.orderdao.getOrderByUser(id);
    }
}

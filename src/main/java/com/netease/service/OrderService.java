package com.netease.service;

import com.netease.meta.CartProduct;
import com.netease.meta.Order;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.List;

/**
 * Created by zjlearn on 2017/3/8.
 */


public interface OrderService {
     boolean  createOrder(int UserId, int productId, CartProduct product);
     List<Order> getOrderbyUser(int id);
}

package com.netease.dao;

import com.netease.meta.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zj on 2017/2/23.
 */
//对订单进行操作的接口

    @Repository
public interface OrderDao {

    public void addOrder(Order order);

    public List<Order> getOrderByUser(int id);

}

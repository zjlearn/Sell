package com.netease.web.controller;

import com.netease.meta.Order;
import com.netease.meta.User;
import com.netease.service.Impl.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zjlearn on 2017/3/1.
 */
@Controller
public class Account {
    @Resource
    OrderServiceImpl orderser;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String  getOrder(HttpSession session, ModelMap model){
            User u = (User)session.getAttribute("user");
            if(u==null)
                return "login";
            int userId  =u.getId();
            List<Order> orders= this.orderser.getOrderbyUser(userId);
            for(Order o: orders)
                System.out.println(o.getPhotoAddress());
            model.addAttribute("orders", orders);
            return "account";
    }
}

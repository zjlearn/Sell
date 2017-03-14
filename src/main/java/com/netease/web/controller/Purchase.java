package com.netease.web.controller;

import com.netease.meta.Cart;
import com.netease.meta.CartProduct;
import com.netease.meta.Product;
import com.netease.meta.User;
import com.netease.service.Impl.ExhibitServiceImpl;
import com.netease.service.Impl.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zjlearn on 2017/3/2.
 */
@Controller
public class Purchase {

    @Resource
    OrderServiceImpl orderser;

    @Resource
    private ExhibitServiceImpl es;

    @RequestMapping(value = "settleAccount")
    public String  settleAccount(ModelMap model, HttpSession session) {
        if(session.getAttribute("cart")!=null) {
            Cart cart = (Cart) session.getAttribute("cart");
            model.addAttribute("cart", cart);
        }
        System.out.println(model);
        return "settleAccount";
    }
    @RequestMapping(value = "addproduct", method = RequestMethod.GET)
    public void addproduct(@RequestParam("title") String title, @RequestParam("price") float price,
                          @RequestParam("id") int id,
                           @RequestParam("num") int num,  HttpSession session){
        Cart cart=null;
        if(session.getAttribute("cart")!=null) {
            cart = (Cart) session.getAttribute("cart");
        }else{
            cart= new Cart();
        }
        cart.addproduct(Integer.toString(id), price,title, num);
        session.setAttribute("cart",cart);
        System.out.println(cart);
        System.out.println("in the addproduct");
    }

    @RequestMapping(value = "createorder")
    public String createOrder(HttpSession session, ModelMap model){
        User u=(User) session.getAttribute("user");
        if(u==null)
            return "login";
        int userId=u.getId();
        Cart cart=(Cart)session.getAttribute("cart");
        HashMap<String, CartProduct> products=cart.getProducts();
        for(String productId: products.keySet()){  //生成订单保存到数据库中
            orderser.createOrder(userId,Integer.valueOf(productId), products.get(productId));
            //这里仍然需要对商品的数量进行修改
        }
        //去除session的商品
        session.removeAttribute("cart");

        return "settleAccount";
    }
}

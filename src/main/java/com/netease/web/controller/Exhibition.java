package com.netease.web.controller;

import com.netease.meta.Cart;
import com.netease.meta.Product;
import com.netease.meta.User;
import com.netease.service.Impl.ExhibitServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.netease.service.Impl.ProductServiceImpl;

import java.util.List;

/**
 * Created by zj on 2017/2/17.
 */

// 好像当RequestMapping 应用于类级别的时候， 只是说该路径将应用于所有的类的所有函数，
//此时仍然需要对类中的函数的映射方法进行补充，当只有一个函数时仍然需要，
// 否则类路径下面的映射控制是不起作用的。
@Controller
@RequestMapping(value = "/")
public class Exhibition {
    //返回展览首页
    @Resource
    private ProductServiceImpl ps;

    @Resource
    private ExhibitServiceImpl es;

    @RequestMapping(method = RequestMethod.GET)
    public String exhibit(ModelMap model, HttpSession session){
        //设置展示的产品方式
        System.out.println("in the exhibit");
        List<Product> Products= es.getAllProducts();
        model.addAttribute("products", Products);
        return "exhibition";
    }

    @RequestMapping(value ="product" , method = RequestMethod.GET)
    public String exhibit(@RequestParam("type") int type, HttpSession session, ModelMap model) {
        //设置展示的产品方式
        if (type == 0) {
            List<Product> allProducts = es.getAllProducts();
            model.addAttribute("products", allProducts);
            return "Allproducts";
        } else if (type == 1) {  //查找未购买的商品
            User u = (User) session.getAttribute("user");
            if(u == null )
                return "reminder";
            int userId = u.getId();
            List<Product> notPurchasedProducts = es.getNotPurchasedProducts(userId);
            if(notPurchasedProducts==null){
                System.out.println("user has  buy all the product!");
            }
            model.addAttribute("products", notPurchasedProducts);
            return "notpurchased";
        } else {
            User u = (User) session.getAttribute("user");
            if(u == null )
                return "reminder";
            int userId = u.getId();
            List<Product> publicedProducts = ps.getProductByOwnerId(userId);
            model.addAttribute("products", publicedProducts);
            return "publishedproducts";
        }

    }
}

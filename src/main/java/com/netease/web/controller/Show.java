package com.netease.web.controller;

import com.netease.meta.Product;
import com.netease.meta.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import  com.netease.service.Impl.ProductServiceImpl;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zj on 2017/2/17.
 */
@Controller

public class Show {
    @Resource
    private ProductServiceImpl productService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    //获取id编号的product的信息
    public String  show(@RequestParam("id") int id, HttpSession session, ModelMap model, HttpServletResponse res){
        Product item = this.productService.getProductById(id);
        model.addAttribute("product", item);
        User u = (User) session.getAttribute("user");
        if(u == null)
            return "show";
        else{
            boolean purchased = productService.isPrurchased(u.getId(), id);
            model.addAttribute("purchased",purchased);
        }
        return "show";
    }
}

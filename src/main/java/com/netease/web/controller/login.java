package com.netease.web.controller;


import com.netease.meta.Product;
import com.netease.service.Impl.ExhibitServiceImpl;
import com.netease.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.netease.meta.User;

/**
 * Created by zj on 2017/2/13.
 */

@Controller
public class login {

    @Resource
    private UserServiceImpl us;

    @Resource
    private ExhibitServiceImpl es;


    @RequestMapping(value = "/login")
    public String login() throws IOException {
        System.out.println("in the login");
        return "login";
    }
    @RequestMapping(value = "/login/user")
    public String Login(@RequestParam("name") String name, @RequestParam("password") String password,
                        HttpSession session, ModelMap model) {
        System.out.println("int the loginuser");
        //设置Session属性，
        User u= us.getUserByName(name);
        //对用户的用户名和密码做验证
        if(u==null || !u.getPassword().equals(password)){  //当密码不对时，仍然返回登录界面
            return "login";
        }
        //用户登录成功，返回到主页面
        session.setAttribute("user",u);

        //找出所有的product, 并设置相应的是否购买过
        List<Product>  allproducts=es.getAllProducts();

        model.addAttribute("products", allproducts);

        return "exhibition";
    }
}

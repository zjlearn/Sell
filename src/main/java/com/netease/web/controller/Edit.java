package com.netease.web.controller;

import com.netease.meta.Product;
import com.netease.service.Impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by zjlearn on 2017/3/2.
 */
@Controller
@RequestMapping(value="/product/")
public class Edit {
    @Resource
    ProductServiceImpl  ps;

    @RequestMapping(value = "edit" , method = RequestMethod.GET)
    public String edit(@RequestParam("productId") int  productId, ModelMap model){
        //get the product from the database
        Product editproduct= ps.getProductById(productId);
        model.addAttribute("product", editproduct);
        return "edit";
    }
    @RequestMapping(value = "save" , method = RequestMethod.POST)
    public String editSave(@RequestParam("productId") int  productId,@RequestParam("name") String name,
                           @RequestParam("summary") String summary, @RequestParam("detail") String detail,
                           @RequestParam("price") String price, @RequestParam("stock") String stock,

                           ModelMap model){
        //get the product from the database
        Product product=new Product();
        ps.updateProduct(product);
        model.addAttribute("product", product);
        System.out.println("int the save");
        return "show";
    }




}

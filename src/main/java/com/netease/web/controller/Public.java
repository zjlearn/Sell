package com.netease.web.controller;

import com.netease.meta.Product;
import com.netease.meta.User;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.netease.service.Impl.ProductServiceImpl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by zj on 2017/2/18.
 */


@Controller
@RequestMapping(value = "/public")
public class Public {
    @Resource
    private ProductServiceImpl ps;

    //返回发布的页面
    @RequestMapping(method = RequestMethod.GET)
    public String pb(HttpSession session){
        User u = (User)session.getAttribute("user");
        if(u==null)
            return "login";
        else
            return "public";
    }



    @RequestMapping(value = "/Submit", method = RequestMethod.POST)
    public String  pbSubmit(@RequestParam("name") String name, @RequestParam("summary") String summary,
                            @RequestParam("detail") String detail, @RequestParam("price") float price,
                            @RequestParam("stock") int stock,
                            @RequestParam(value = "image", required = false) String imageAddress,
                            @RequestPart(value = "productPicture" , required = false) MultipartFile productPicture,
                            HttpSession session, ModelMap model) throws IOException{
            User u=(User)session.getAttribute("user");
            if(u == null ){ //返回到登录界面
                return  "login";
            }
            int ownerId=u.getId();
            String picAddress=null;

             System.out.println(imageAddress);
            if (imageAddress.length()>5) {
                System.out.println("use net pic");
                picAddress=imageAddress;
            } else{
                //将图片数据上传到服务器
                System.out.println("use the local pic");
                String imageServer = "G:\\picServer\\";
                String filepath = imageServer + productPicture.getOriginalFilename();
                System.out.println(filepath);
                productPicture.transferTo(new File(filepath));
                picAddress="/pic/"+productPicture.getOriginalFilename();
            }

            //上传成功之后保存相应的地址
            BigDecimal pr =new BigDecimal(price);
            Product p = new Product(name, ownerId, stock, summary, detail, pr, picAddress);
            ps.insertProduct(p);
            model.addAttribute("product", p);
            return "pbSubmit";
    }
}

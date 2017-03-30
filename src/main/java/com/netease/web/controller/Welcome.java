package com.netease.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zj on 2017/2/13.
 */

@Controller
@RequestMapping(value = "hello", method = RequestMethod.GET)
public class Welcome {
    public String  hello(){
        return "hello";
    }
}

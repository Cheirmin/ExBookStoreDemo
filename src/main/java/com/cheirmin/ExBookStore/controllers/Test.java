package com.cheirmin.ExBookStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Message:
 * @Author：Cheirmin
 * @Date: 2019/11/30 12:01
 * @Version 1.0
 */
@Controller
public class Test {

    @RequestMapping("index.do")
    public String test(Model model){
        System.out.println("------------index----------");
        return "index";
    }

    @RequestMapping("header.do")
    public String header(Model model){
        System.out.println("------------header----------");
        return "usercenter";
    }

    @RequestMapping("footer.do")
    public String footer(Model model){
        System.out.println("------------footer----------");
        return "footer";
    }
}

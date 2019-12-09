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
    public String index(Model model){
        System.out.println("------------index----------");
        return "index";
    }

    @RequestMapping("test.do")
    public String test(String str){
        System.out.println("------------" + str + "----------");
        return str;
    }
}

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

    @RequestMapping("test.do")
    public String test(Model model){
        System.out.println("------------test----------");
        model.addAttribute("username","张三");
        return "index";
    }
}

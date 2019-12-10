package com.cheirmin.ExBookStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Message:用户相关
 * @Author：Cheirmin
 * @Date: 2019/12/9 15:22
 * @Version 1.0
 */
@Controller
public class User {

    /*******************************************************
     *
     *   登陆注册模块
     *
     ******************************************************/
    //登录
    @RequestMapping("user/login")
    public String login(){
        System.out.println("-----user/login-----");
        return "user/login";
    }

    //注册
    @RequestMapping("user/register")
    public String register(){
        System.out.println("-----user/register-----");
        return "user/register";
    }

    //找回密码
    @RequestMapping("user/retrievepassword")
    public String retrievepassword(){
        System.out.println("-----user/retrievepassword-----");
        return "user/retrievepassword";
    }

    /*******************************************************
     *
     *   个人中心模块
     *
     ******************************************************/

    //地址管理
    @RequestMapping("personal/address")
    public String address(){
        System.out.println("-----personal/address-----");
        return "personal/address";
    }

    //个人中心
    @RequestMapping("personal/usercenter")
    public String usercenter(){
        System.out.println("-----personal/usercenter-----");
        return "personal/index";
    }
}

package com.cheirmin.ExBookStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Message:书城相关
 * @Author：Cheirmin
 * @Date: 2019/12/9 15:22
 * @Version 1.0
 */
@Controller
public class BookStore {

    /*******************************************************
     *
     *   浏览模块
     *
     ******************************************************/
    //书店主页
    @RequestMapping("index")
    public String index(){
        System.out.println("-----index-----");
        return "index";
    }

    //店家推荐

    //商品详情

    //新书详细区

    //旧书卖场详细区

    //浏览市价收书模块

    /*******************************************************
     *
     *   买书交易模块
     *
     ******************************************************/

    //购物车

    //订单模块

    //付款

    //收货

    /*******************************************************
     *
     *   卖书交易模块
     *
     ******************************************************/

    //上传图书

}

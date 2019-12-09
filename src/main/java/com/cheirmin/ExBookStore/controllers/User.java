package com.cheirmin.ExBookStore.controllers;

import com.cheirmin.ExBookStore.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

/**
 * @Message:
 * @Author：Cheirmin
 * @Date: 2019/12/9 15:22
 * @Version 1.0
 */
@Controller
public class User {
    @RequestMapping("verfy.do")
    public boolean VerifyCode(){
        File dir = new File("C:\\Users\\11479\\Desktop\\");
        int w = 200, h = 80;
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        File file = new File(dir, verifyCode + ".jpg");
        try {
            VerifyCodeUtils.outputImage(w, h, file, verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

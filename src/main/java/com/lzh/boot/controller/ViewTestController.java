package com.lzh.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
   @GetMapping("/lzh")
    public String lzh(Model model){//也可以放上数据
       //model数据会放到请求域中，相当于调用了request.setAttribute
       model.addAttribute("msg","你好，梁展恒");
       model.addAttribute("link","https://www.baidu.com");
       //按照thymeleaf官方规则，html文件放在templates文件夹上，而且不用加后缀
        return "success";
    }
}

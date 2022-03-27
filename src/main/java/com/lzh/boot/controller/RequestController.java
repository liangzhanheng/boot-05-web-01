package com.lzh.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request){
        request.setAttribute("msg","成功了");//用原生的request给域中放入值
        request.setAttribute("code","200");
        return  "forward:/success";//跳转到这个文件下的success页面，把域中的值转发过去
    }

   @ResponseBody//把域中的值以json格式返回给浏览器
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,//用@RequestAttribute方式拿到域中的值
                       @RequestAttribute("code") Integer code,//用@RequestAttribute方式拿到域中的值
                       HttpServletRequest request   //原生的方式获取
    ){
        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("msg1",msg1);
        map.put("code",code);
        return map;
    }
}

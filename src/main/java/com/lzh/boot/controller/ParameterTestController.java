package com.lzh.boot.controller;

import com.lzh.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.*;

@RestController
public class ParameterTestController {
    /*
        数据绑定：页面提交的请求数据（GET、POST）都可以和对象属性进行绑定
    */
   //POJO封装测试
    @PostMapping("/saveUser")
        public Person saveUser(Person person){
        return person;
    }


    //Rest风格
    @GetMapping("/car/{id}/owner/{userName}")//路径上有两个值
        public Map<String,Object> getCar(@PathVariable("id") Integer id,//用@PathVariable("id")把路径中的id拿到
                                         @PathVariable("userName") String name,//用@PathVariable("userName")把路径中的id拿到
                                         @PathVariable Map<String,String> pv,//用@PathVariable把路径中的所有值拿到，放到Map中
                                         @RequestHeader("User-Agent") String userAgent,//用@RequestHeader获取指定请求头的名称
                                         @RequestHeader Map<String,String> header, //用@RequestHeader把所有请求头用map拿到
                                         @RequestParam("age") Integer age,//用@RequestParam获取请求参数age的值
                                         @RequestParam("interest") List<String> interest,//用@RequestParam获取请求参数interest的值，
                                         // interest有多个，用集合表示
                                         @RequestParam Map<String,String> param ,//用@RequestParam获取所有请求参数的值
                                         @CookieValue("Idea-9465f02e") String Idea, //用@CookieValue获取指定cookie的值
                                         @CookieValue("Idea-9465f02e") Cookie cookie//注意是HTTP里面的Cookie对象；用@CookieValue获取指定cookie的所有信息
    ) {
        //创建Map对象
        Map<String,Object> map= new HashMap<>();
        //讲数据放进map中
//        map.put("id",id);
//        map.put("userName",name);
//        map.put("pv",pv);

        //请求头名称
//        map.put("userAgent",userAgent);
//        map.put("header",header);

//        //请求参数的值
        map.put("age",age);
        map.put("interest",interest);
        map.put("param",param);

        //cookie的值
        map.put("Idea",Idea);
    //打印cookie的所有信息
        System.out.println(cookie+cookie.getName()+"\n"+cookie.getValue());
        return map;
        }
        @PostMapping("/save")
        public Map postMethod(@RequestBody String content){//用@RequestBody把请求体--如表单的数据拿过来
            Map<String,Object> map= new HashMap<>();
            map.put("content",content);
            return map;
        }

        /*
        注意：SpringBoot默认禁用了矩阵变量，所以要手动开启
        原理：对于路径的处理，UrlPathHelper对其进行了解析
              用 removeSemicolonContent（移除分号内容）支持矩阵变量，所以要自定义
        手动开启：较麻烦，后期学习。
        第一种方式  语法：/cars/sell;low=34;brand=byd,audi,yd

        */
//        @GetMapping("/cars/{path}}")
//        public Map casSell(@MatrixVariable("low") Integer low,//用@MatrixVariable获取矩阵变量的值，即low=34;brand=byd,audi,yd
//                           @MatrixVariable("brand") List<String> brand,
//                           @PathVariable("path") String path//拿到路径里面的sell变量值
//                           ){
//            Map<String, Object> map = new HashMap<>();
//            map.put("low",low);
//            map.put("brand",brand);
//            map.put("path",path);
//            return map;
//        }

}

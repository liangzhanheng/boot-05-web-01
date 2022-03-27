package com.lzh.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

@RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

//@RequestMapping(value = "/user",method = RequestMethod.GET) 与下面@GetMapping("/user")等同
    @GetMapping("/user")
    public String getUser(){
        return "GET+张三";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST+张三";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){
        return "PUT+张三";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE+张三";
    }




}

package com.lzh.boot.controller;

import com.lzh.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {
    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
      Person person=new Person();
      person.setAge(18);
      person.setUserName("aaa");
      person.setBirth(new Date());
        return person;
    }
}

package com.example.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class HelloController2 {
    @RequestMapping("/check")
    public String hello(Model m)throws Exception {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        if(true){
            throw new Exception("some exception");
        }
        return "hello.jsp";
    }
}

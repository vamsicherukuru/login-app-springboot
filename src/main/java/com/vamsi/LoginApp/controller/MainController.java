package com.vamsi.LoginApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/")
    public String indexPage(){

        return "index";
    }

    @GetMapping("/user")
    public String userPage(){

        return "user";
    }

    @GetMapping("/admin")
    public String adminPage(){

        return "admin";
    }
}

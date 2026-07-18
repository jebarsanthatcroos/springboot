package org.example.springboot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class home {

    @GetMapping
    public String gethomePage(){
        return "Welcome to home page";
    }
    @GetMapping("/Dashbord")
    public String getdashbordPage(){
        return "Welcome to Dashbord page";
    }


}

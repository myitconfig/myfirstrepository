package com.myitconfig.gitdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

    @RequestMapping("/email")
    public String testGit(){
        
        return "git";
    }
}

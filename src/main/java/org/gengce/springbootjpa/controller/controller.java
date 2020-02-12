package org.gengce.springbootjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

    @RequestMapping("/code")
    public String testCode(){

        return "code";
    }
}

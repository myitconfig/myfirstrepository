package com.springboot.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springboot-aop
 * @description: Aop连接点
 * @author: myitconfig
 * @create: 2020-04-08 10:44
 **/

@Controller
public class JoinPointController {
    @RequestMapping("/curry")
    public String curry(ModelMap modelMap){
        modelMap.put("name","库里");
        System.out.println("库里上场打球了!!");
        return "nba";
    }
    @RequestMapping("/zimu")
    public void antetokounmpo(){
        System.out.println("安特托昆博上场打球了!!");
    }
    @RequestMapping("/jokic")
    public void jokic(){
        System.out.println("约基奇上场打球了!!");
    }
    @RequestMapping("/durant")
    public void durant(){
        System.out.println("杜兰特上场打球了!!");
    }


}

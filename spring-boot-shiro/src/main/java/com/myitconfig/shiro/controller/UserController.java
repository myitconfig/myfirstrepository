package com.myitconfig.shiro.controller;

import com.myitconfig.shiro.pojo.UserBean;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @RequestMapping("/user/index")
    public String add(HttpServletRequest request) {
        UserBean bean = (UserBean) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute("userName", bean.getName());
        return "/user/index";
    }

    @RequestMapping("/vip/index")
    public String update() {
        return "/vip/index";
    }
}

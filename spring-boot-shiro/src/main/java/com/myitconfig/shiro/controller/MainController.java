package com.myitconfig.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class MainController {
    private Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/main")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("root", request.getContextPath());
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("root", request.getContextPath());
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam String username, @RequestParam String password) {
        response.setHeader("root", request.getContextPath());
        if (!StringUtils.isEmpty(username)) {
            Subject subject = SecurityUtils.getSubject();  // 1.获取Subject
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);  // 2.封装用户数据
            try {
                subject.login(token); // 3.执行登录方法
                return "redirect:/main";
            } catch (UnknownAccountException e) {
                log.info("用户名不存在!");
                request.setAttribute("msg", "用户名不存在！");
            } catch (IncorrectCredentialsException e) {
                log.info("密码错误8");
                request.setAttribute("msg", "密码错误！");
            }
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "redirect:/main";
    }

    @RequestMapping("/error/unAuth")
    public String unAuth() {
        return "/error/unAuth";
    }
}

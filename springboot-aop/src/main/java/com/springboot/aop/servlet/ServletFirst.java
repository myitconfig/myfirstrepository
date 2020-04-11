package com.springboot.aop.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: springboot-aop
 * @description: servlet测试
 * @author: myitconfig
 * @create: 2020-04-09 22:23
 **/
@WebServlet(name="FirstServlet",urlPatterns = "/first")
public class ServletFirst extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("初始化数据");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("访问百度");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("servlet已经销毁");
    }
}

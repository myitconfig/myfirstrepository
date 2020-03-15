package com.langsin.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(filterName = "MyFilter",urlPatterns = {"/first","*.action"})
public class MyFilter implements  Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("进入拦截器");
			chain.doFilter(request, response);
			System.out.println("已被放行");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}

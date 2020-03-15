
package com.langsin.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalException2 implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv=new ModelAndView();
		if (ex instanceof NullPointerException) {
			mv.setViewName("error1");
		}
		if (ex instanceof ArithmeticException) {
			mv.setViewName("error2");
		}
		mv.addObject("error");
		return mv;
	}

}

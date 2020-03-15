package com.langsin.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * 全局异常处理类
 * @author Admin
 *
 */
@ControllerAdvice
public class GlobalException {

	/*
	 * 异常1
	 */
	@ExceptionHandler(value = java.lang.NullPointerException.class)
	public ModelAndView dealException(Exception e) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("error",e.toString());
		mv.setViewName("error1");
		return mv; 
	}
	/*
	 * 异常2
	 */
	@ExceptionHandler(value = java.lang.ArithmeticException.class)
	public ModelAndView dealException1(Exception e) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("error",e.toString());
		mv.setViewName("error2");
		return mv; 
	}
	
}

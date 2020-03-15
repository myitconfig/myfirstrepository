package com.langsin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan//注解方式
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//通过方法注入
//	@Bean
//	public ServletRegistrationBean getServletRegistrationBean() {
//		ServletRegistrationBean bean=new ServletRegistrationBean(new MyServlet());
//		bean.addUrlMappings("/second");
//		return bean;
//		
//	}
	
//	@Bean
//	public FilterRegistrationBean getfiFilterRegistrationBean() {
//		FilterRegistrationBean bean =new FilterRegistrationBean(new MyFilter());
//		bean.addUrlPatterns("/second");
//		return bean;
//	}
	
//	@Bean
//	public ServletListenerRegistrationBean<MyListener> getServletListenerRegistrationBean(){
//		ServletListenerRegistrationBean<MyListener> bean=new ServletListenerRegistrationBean<>(new MyListener());
//		return bean;
//	}
	
}

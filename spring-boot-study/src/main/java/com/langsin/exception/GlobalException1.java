package com.langsin.exception;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class GlobalException1 {

	@Bean
	public SimpleMappingExceptionResolver getResolver() {
		SimpleMappingExceptionResolver resolver=new SimpleMappingExceptionResolver();
		Properties propertiesMapping=new Properties();
		propertiesMapping.put("java.lang.NullPointerException", "error1");
		propertiesMapping.put("java.lang.ArithmeticException", "error2");
		resolver.setExceptionMappings(propertiesMapping);
		return resolver;
	}
}

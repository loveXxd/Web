//package com.wqc.controller;
//
//import java.util.Properties;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jmx.export.annotation.ManagedAttribute;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
//
///**
// * 此种方法可以对不同的异常进行相应的类型匹配映射但是不能向页面传递异常参数等
// * @author Administrator
// *
// */
//@Configuration
//public class ExcepetionController3 {
//	@Bean
//	public SimpleMappingExceptionResolver geTypeResolver() {
//		SimpleMappingExceptionResolver resolver =new SimpleMappingExceptionResolver();
//		Properties mappings=new Properties();
//		/**
//		 * 参数1 异常类型全名
//		 * 参数2 跳转试图名称
//		 */
//		mappings.put("java.lang.ArithmeticException", "errorsall");
//		resolver.setExceptionMappings(mappings);
//		return resolver;
//	}
//	
//}

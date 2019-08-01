package com.wqc.controller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 通过实现 HandlerExceptionResolver 做异常处理 比三优势可传参数
 * @author Administrator
 *
 */
@Configuration
public class ExcepetionController4 implements HandlerExceptionResolver {


	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
	
		// TODO Auto-generated method stub
		ModelAndView mv = new ModelAndView();
		if (ex instanceof ArithmeticException) {
			mv.setViewName("errors");
		} else {
			mv.setViewName("errorsall");
		}
		mv.addObject("errors",ex.toString());
		//判断类型跳转
		return mv;
	}
	
}

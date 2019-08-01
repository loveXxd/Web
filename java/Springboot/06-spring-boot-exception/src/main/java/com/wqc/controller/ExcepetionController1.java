package com.wqc.controller;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

/**
 * 
 * 加上@ControllerAdvice其类内部对于异常的处理会变成全局的
 * @author Administrator
 *
 */
@Controller
public class ExcepetionController1 {

	@RequestMapping("/{page}")
	public String shoePage(@PathVariable String page) {
		return page;
	}
	/**
	 * 默认处理有error跳转errror
	 * @return
	 */
	@RequestMapping("/exce")
	public String exception1() {
		String string=null;
		string.length();
		return "exce";
	}
	@RequestMapping("/exce2")
	public String exception2() {
		int a=0;
		int b=10/a;
		return "exce";
	}

	
	
	
}

package com.wqc.controller;
//package com.wqc.controller;
//
//import org.springframework.jmx.export.annotation.ManagedAttribute;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//
//@ControllerAdvice
//public class ControllerExceptionHandler {
//
//	@RequestMapping("/{page}")
//	public String shoePage(@PathVariable String page) {
//		return page;
//	}
//	/**
//	 * 默认处理有error跳转errror
//	 * @return
//	 */
//	@RequestMapping("/exce3")
//	public String exception1() {
//		String string=null;
//		string.length();
//		return "exce";
//	}
//	@RequestMapping("/exce4")
//	public String exception2() {
//		int a=0;
//		int b=10/a;
//		return "exce";
//	}
//	/**
//	 * 定义想处理异常根据判断类跳转定义页面
//	 * 只在此类中接口有作用
//	 * @return
//	 */
//	@ExceptionHandler(value={java.lang.ArithmeticException.class})
//	public ModelAndView excepsome(Exception e) {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("errors",e.toString());
//		mv.setViewName("errors");
//		return mv;
//	}
//	
//	
//}

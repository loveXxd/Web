package com.wqc;

import javax.servlet.annotation.WebServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.wqc.filter.SecondFilter;
import com.wqc.listener.SecondListener;
import com.wqc.serverlet.MyServlet2;

/**
 * 启动
 * @author Administrator
 *
 */
@SpringBootApplication
public class App2 {

	public static void main(String[] args) {
		SpringApplication.run(App2.class, args);
	}
	
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet2());
		bean.addUrlMappings("/second");
		return bean;
		
	}
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
		//bean.addUrlPatterns(new String[] {"*.do","*.jsp"});//可以用方法绑定多个servlet
		bean.addUrlPatterns("/second");
		return bean;
	}
	@Bean
	public ServletListenerRegistrationBean<SecondListener> getseListenerRegistrationBean() {
		ServletListenerRegistrationBean<SecondListener> bean =new ServletListenerRegistrationBean<SecondListener>(new SecondListener());
		return bean;
	}

}

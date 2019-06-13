package com.wqc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 * spring boot filter实现就是对接口的一种过滤 在接口处调用前和接口调用后的数据处理和判定
 * @author Administrator
 * *以往的filter配置是在web.xml定义接口
 *	 <filter>
 *		 <filter-name>MyServlet</filter-name>
 *		 <filter-class>com.wqc.filter.FirstFilter</filter-class>
 *	 </filter>
 *	 <filter-mapping>
 *	 	<filter-name>Firdtfilter</servelet-name>
 *		 <url-pattern>/first</url-pattern>
 *	 </filter-mapping>
 *
 *
 *
 */
//@WebFilter(filterName="FirstFilter",urlPatterns= {"*.do","*.jsp"}) 
//其中一个filter可以匹配多个接口 urlPatterns是以数组的形式传递的
@WebFilter(filterName="FirstFilter",urlPatterns="/first")
public class FirstFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("进入Filter");
		chain.doFilter(request, response);
		System.out.println("俩开Filter");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

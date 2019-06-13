package com.wqc.serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * spring boot servlet实现
 * @author Administrator
 * *以往的servlet配置是在web.xml定义接口
 *<servlet>
 *		 <servlet-name>MyServlet</servlet-name>
 *		 <servlet-class>com.wqc.serverlet.MyServlet</servlet-class>
 *	 </servlet>
 *	 <servlet-mapping>
 *	 	<servlet-name>MyServlet</servlet-name>
 *		 <url-pattern>/first</url-pattern>
 *	 </servlet-mapping>
 *
 *
 *
 */
@WebServlet(name="MyServlet",urlPatterns="/myser")
public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		System.out.println("First servlet");
	}
}

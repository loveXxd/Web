package com.wqc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * spring boot Listener
 * @author Administrator
  * 原本的需要在web.xml配置的内容
  *不同的监听类型会实现不同的类 ServletContextListener
 * <listener>
 * 		<listener-class>com.wqc.listener.FirstListener</listener-class>
 * </listener>
 *
 *
 */
@WebListener
public class firstListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("listener init");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}

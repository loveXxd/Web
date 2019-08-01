package com.wqc;

import javax.servlet.annotation.WebServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.wqc.serverlet.MyServlet2;

/**
 * 启动
 * @author Administrator
 *
 */
@SpringBootApplication
@ServletComponentScan  //在启动的时候扫描项目内的 @WebServlet 并将该类实例化
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

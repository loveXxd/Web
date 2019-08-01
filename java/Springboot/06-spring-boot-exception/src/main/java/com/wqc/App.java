package com.wqc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
public static void main(String[] args) {
	SpringApplication.run(App.class, args);
	/**
	 * 多种异常方式可能冲突  调试的时候注意注释
	 */
}
}

package com.wqc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	//redis-server.exe redis.windows.conf 启动命令
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

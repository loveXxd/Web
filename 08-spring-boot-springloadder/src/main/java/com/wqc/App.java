package com.wqc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	/**
	 * 第一种方式
	 * 启动时右键项目Spring-boot:run
	 * 只能动态更新java  页面修改无效
	 * 启动时是以进程的方式运行需要手动杀死 去运行里面找到java.exe
	 * 
	 * 第二种法师
	 * 下载springloader夹包放到lib目录下
	 * 然后在启动时候需要 启动runas下的run config并在左侧选择java application下的要启动的项目
	 * 选中argumnets 并在vmargumnent中输入   
	 *  -javaagent:.\lib\springloaded-1.2.5.RELEASE.jar -noverify
	 *	前后参数一样只有中间参数在改变
	 *	只能动态更新java  页面修改无效
	 *   但是启动和停止相对简单
	 *   
	 *  devtool热部署
	 *  直接在pom加一个配置
	 *  <!-- spring boot 热更新 -->
	 *	<dependency> 
	 *	<groupId>org.springframework.boot</groupId> 
	 *	<artifactId>spring-boot-devtools</artifactId> 
	 *		<optional>true</optional>
	 *		 <scope>true</scope>
	 *	 </dependency>
	 *启动和以往一样而且页面以及java的更改都可以检车更新
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

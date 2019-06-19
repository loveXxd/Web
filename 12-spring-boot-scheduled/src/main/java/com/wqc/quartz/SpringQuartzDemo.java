package com.wqc.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.wqc.service.UsersService;
/**
 * spring
 * 定义任务类
 * @author Administrator
 *
 */
public class SpringQuartzDemo implements Job {

	@Autowired
	private UsersService usersService;
	/**
	 * 任务被触发时执行的方法
	 */
	@Override
	public void execute(JobExecutionContext context) {
		// TODO Auto-generated method stub
		//System.out.println("execute-----------"+new Date());
		this.usersService.addUSers();
	}

}

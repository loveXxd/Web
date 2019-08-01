package com.wqc.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 定义任务类
 * @author Administrator
 *
 */
public class QuartzDemo implements Job {

	/**
	 * 任务被触发时执行的方法
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("execute"+new Date());
	}

}

package com.wqc;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import com.wqc.quartz.QuartzDemo;

public class QuartzMain {

	public static void main(String[] args) throws SchedulerException {
		// TODO Auto-generated method stub

		// 1.创建job对象 你要做什么事
		JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();
		/**
		 * 简单的trigger 触发时间 通过quartz提供一个方法来完成简单的重复调用 cron triiger 
		 * SimpleScheduleBuilder.repeatSecondlyForever()
		 * 按照cron的表达式来给定的触发时间
		 * CronScheduleBuilder.cronSchedule("0/2 * * * * ?")
		 */
		// 2.创建Trigger对象 你要什么时间做
		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
				.build();
		// 3.创建Scheduler对象 在什么时间做什么事
		Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
	}

}

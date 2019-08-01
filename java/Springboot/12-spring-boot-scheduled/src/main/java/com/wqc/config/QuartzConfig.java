package com.wqc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.wqc.quartz.SpringQuartzDemo;
/**
 * Quartz配置类
 */
@Configuration
public class QuartzConfig {
	
		// 1.创建job对象 你要做什么事
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factory=new JobDetailFactoryBean();
		factory.setJobClass(SpringQuartzDemo.class);
		return factory;
	}
	
		/**
		 * 简单的trigger 触发时间 通过quartz提供一个方法来完成简单的重复调用 cron triiger 
		 *
		 * 按照cron的表达式来给定的触发时间
		 *
		 */
		// 2.创建Trigger对象 你要什么时间做
//		@Bean
//		public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
//			SimpleTriggerFactoryBean factory=new SimpleTriggerFactoryBean();
//			//关联jobDetail
//			factory.setJobDetail(jobDetailFactoryBean.getObject());
//			//参数是执行的毫秒数
//			factory.setRepeatInterval(200);
//			//设置次数
//			factory.setRepeatCount(4);
//			return factory;
//		}
	// 按照cron的表达式来给定的触发时间
			@Bean
			public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
				CronTriggerFactoryBean factory=new CronTriggerFactoryBean();
				factory.setJobDetail(jobDetailFactoryBean.getObject());
				factory.setCronExpression("0/2 * * * * ? ");
				return factory;
			}
	
		// 3.创建Scheduler对象 在什么时间做什么事
//		@Bean
//		public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean) {
//			SchedulerFactoryBean factory=new SchedulerFactoryBean();
//			//关联trrigger
//			factory.setTriggers(simpleTriggerFactoryBean.getObject());
//			return factory;
//		}
			
			@Bean
			public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory) {
				SchedulerFactoryBean factory=new SchedulerFactoryBean();
				//关联trrigger
				factory.setTriggers(cronTriggerFactoryBean.getObject());
				factory.setJobFactory(myAdaptableJobFactory);
				return factory;
			}
	
}

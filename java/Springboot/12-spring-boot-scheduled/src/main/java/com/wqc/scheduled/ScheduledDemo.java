package com.wqc.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * scheduled定时任务器
 * @author Administrator
 *
 */
//@Component
public class ScheduledDemo {

	/**
	 * @Scheduled(cron="")定时任务
	 * cron属性 cron表达式 定时任务触发是时间的一个字符串表达形式
	 * 秒 分 时 日 月 年 星期 是设定特定的时间执行如每分钟第三秒  ？任意 -范围  ,and  0/2间隔
	 */
	@Scheduled(cron="0/2 * * * * ?")
	
	public void scheduledMethod() {
		System.out.println("定时器被处罚"+new Date());
	}
}

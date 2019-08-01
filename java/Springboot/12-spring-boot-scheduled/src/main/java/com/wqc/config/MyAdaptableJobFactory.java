package com.wqc.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {

	/**
	 * autowireCapableBeanFactory可以将对象手动的添加到springIOC容器中并且完成对象注入
	 */
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;
	/**
	 * 该方法需要将实例化的任务类对象手动的添加到springIOC容器中并且完成对象注入
	 */
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		Object obj= super.createJobInstance(bundle);
		this.autowireCapableBeanFactory.autowireBean(obj);
		return  obj;
	}

}

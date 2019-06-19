package com.wqc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

	/**
	 * 1.创建jedispoolconfig对象并实现一些连接池的配置
	 * @ConfigurationProperties(prefix="redis.test")将检测application中前缀相同的值进行匹配然后根据后面特定键和值设置
	 */
	@Bean
	@ConfigurationProperties(prefix="redis.test")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig config=new JedisPoolConfig();
//		//最大空闲数   
//		config.setMaxIdle(10);
//		//最小空闲数
//		config.setMinIdle(5);
//		//最大连接数
//		config.setMaxTotal(20);
		System.out.println("默认值"+config.getMaxIdle());
		System.out.println("默认值"+config.getMinIdle());
		System.out.println("默认值"+config.getMaxTotal());
		return config;
	}
	/**
	 * 2.配置jedisconnectiobfactory 配置redis连接信息
	 */
	@Bean
	@ConfigurationProperties(prefix="redis.test")
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config) {
		System.out.println("默认值"+config.getMaxIdle());
		System.out.println("默认值"+config.getMinIdle());
		System.out.println("默认值"+config.getMaxTotal());
		JedisConnectionFactory factory=new JedisConnectionFactory();
		//关联连接池的配置对象
		factory.setPoolConfig(config);
//		//配置连接的redis对象
//		//主机地址
//		factory.setHostName("127.0.0.1");
//		//端口
//		factory.setPort(6379);
		return factory;
	}
	/**
	 * 创建redistemplate 用于执行redis操作方法
	 */
	@Bean
	public RedisTemplate<String, Object>redisTemplate(JedisConnectionFactory factory){
		RedisTemplate<String, Object> template =new RedisTemplate<String, Object>();
		//关联
		template.setConnectionFactory(factory);
		//key 设置序列化器
		template.setKeySerializer(new StringRedisSerializer());
		//value 设置序列化器
		template.setValueSerializer(new StringRedisSerializer());
		return template;
	}
	
}

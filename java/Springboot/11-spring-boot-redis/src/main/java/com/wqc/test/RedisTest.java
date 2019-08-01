package com.wqc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wqc.App;
import com.wqc.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class RedisTest {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	@Test
	public void testSet() {
		this.redisTemplate.opsForValue().set("key2", "大帅哥2");
		System.out.println(this.redisTemplate.opsForValue().get("key"));
	}
	/**
	 * 存储对象的话要转化存取序列化格式
	 * this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
	 * 并且对象要继承 Serializer接口
	 */
	@Test
	public void testSetObj() {
		Users users=new Users();
		users.setAge(10);
		users.setName("王五");
		users.setId(0);
		
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		this.redisTemplate.opsForValue().set("keyobj", users);
	}
	@Test
	public void testGetObj() {
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Users users= (Users)this.redisTemplate.opsForValue().get("keyobj");
		System.out.println(users);
	}
	@Test
	public void testSetObjjson() {
		Users users=new Users();
		users.setAge(10);
		users.setName("王五");
		users.setId(0);
		
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Users>(Users.class));
		this.redisTemplate.opsForValue().set("keyobj_json", users);
	}
	@Test
	public void testGetObjjson() {
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Users>(Users.class));
		Users users= (Users)this.redisTemplate.opsForValue().get("keyobj_json");
		System.out.println(users);
	}
}

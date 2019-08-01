package com.wqc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wqc.App;
/**
 * 测试类
 * @author Administrator
 *eunwith 启动器
 *SpringJUnit4ClassRunner.class让junit和spring环境进行整合
 *@SpringBootTest(classes= {App.class})有两个作用
 *1.定做springboot的测试类
 *2.加载springboot启动器启动springboot
 *junit和spring整合
 *@ContextConfiguration("classspath:applicatiobContext.xml")

 */
import com.wqc.service.UsersServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {App.class})
public class USersServiceTest {

	@Autowired
	private UsersServiceImpl usersServiceImpl;
	
	@Test
	public void testAddUSer() {
		this.usersServiceImpl.addUSers();
	}
	
}

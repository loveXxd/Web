package com.wqc.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wqc.App;
import com.wqc.pojo.Users;
import com.wqc.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersServiceTest {
	@Autowired
	private UsersService usersService;
	
	@Test
	public void findUserById() {
		System.out.println(this.usersService.findUserById(1)); 
		
		System.out.println(this.usersService.findUserById(1));
		
	}
	
	@Test
	public void fundPageable() {
		Pageable pageable=new PageRequest(0,2);
		System.out.println(this.usersService.findUsersByPage(pageable).getTotalElements());
		
		System.out.println(this.usersService.findUsersByPage(pageable).getTotalElements());
		
		pageable=new PageRequest(1,2);
		System.out.println(this.usersService.findUsersByPage(pageable).getTotalElements());
		
	}
	
	@Test
	public void findall() {
		
		System.out.println(this.usersService.findUSersAll().size());
		
		Users users=new Users();
		users.setName("王八蛋");
		this.usersService.saveUsers(users);
		
		System.out.println(this.usersService.findUSersAll().size());
		
		System.out.println(this.usersService.findUSersAll().size());
		
	}
	
}

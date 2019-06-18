package com.wqc.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wqc.App;
import com.wqc.dao.UsersRepository;
import com.wqc.pojo.Roles;
import com.wqc.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class OneToMany {
	@Autowired
	private UsersRepository usersRepository;
	@Test
	public void saveRole() {
		//创建用户
		Users users=new Users();
		users.setAddres("贵州");
		users.setAge(66);
		users.setName("李白");
		
		//创建权限
		Roles roles=new Roles();
		roles.setRolename("管理员");
		//双向绑定
		roles.getUsers().add(users);
		users.setRoles(roles);
		//双向存储
		this.usersRepository.save(users);
	}
	@Test
	public void testfind() {
		Users users = this.usersRepository.findOne(6);
		System.out.println(users);
		
		Roles roles=users.getRoles();
		System.out.println(roles.getRolename());
	}
}

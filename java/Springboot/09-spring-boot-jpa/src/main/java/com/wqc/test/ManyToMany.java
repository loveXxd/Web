package com.wqc.test;

import java.util.Set;

import javax.persistence.Table;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wqc.App;
import com.wqc.dao.RolesRepository;
import com.wqc.pojo.Menus;
import com.wqc.pojo.Roles;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class ManyToMany {

	@Autowired
	private RolesRepository rolesRepository;
	
	@Test
	public void savaManyYoMany() {
		//创建角色对象
		Roles roles=new Roles();
		roles.setRolename("董事长");
		//创建菜单对象
		Menus menus =new Menus();
		menus.setMenusname("经理");
		menus.setFatherid(0);
		
		Menus menus2 =new Menus();
		menus2.setMenusname("店长");
		menus2.setFatherid(1);
		//关联
		roles.getMenus().add(menus);
		roles.getMenus().add(menus2);
		menus.getRoles().add(roles);
		menus2.getRoles().add(roles);
		
		//保存
		this.rolesRepository.save(roles);
	}
	
	
	@Test
	@Transactional//sesion过期
	public void testFind(){
		Roles roles = this.rolesRepository.findOne(2);
		System.out.println(roles.getRolename());
		Set<Menus> menus = roles.getMenus();
		for (Menus menus2 : menus) {
			System.out.println(menus2);
		}
	}
}

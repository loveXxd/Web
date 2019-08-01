package com.wqc.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.wqc.pojo.Users;
/**
 * 
 * @author Administrator
 * Repository方法的命名查询
 *
 */
public interface UsersRepositoryByName extends Repository<Users, Integer> {

	//方法命名必须驼峰 findBy(表示查询)+属性名称(首字母大写)+查询条件(首字母大写)
	 List<Users> findByName(String name);
	 
	 List<Users> findByNameLike(String name);
	 
	 List<Users> findByNameAndAge(String name,Integer age);
}

package com.wqc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.wqc.pojo.Users;

public interface UsersRepositoryQueryAnnotation extends Repository<Users, Integer> {

	@Query("from Users where name = ?")
	List<Users> queryByNameHQL(String name); 
	
	//nativeQuery是否需要转换为sql 上面不是标准sql所以默认为false转换 true为不转换
	@Query(value="select * from t_users where name = ?",nativeQuery=true)
	List<Users> queryByNameSQL(String name);
	
	@Query("update Users set name = ? where id = ?")
	@Modifying
	void updateUSersNameById(String name,Integer id);
	
	
}

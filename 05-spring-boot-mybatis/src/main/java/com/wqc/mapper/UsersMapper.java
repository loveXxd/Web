package com.wqc.mapper;

import java.util.List;

import com.wqc.pojo.Users;

public interface UsersMapper {

	void insertUser (Users users);
	
	List<Users> selectUserAll();
	
	Users selectUsersById(Integer id);
	
	void updataUser(Users users);
	
	void deleteUserById(Integer id);
	
	void insertAdms (Users users);
}

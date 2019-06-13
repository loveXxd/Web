package com.wqc.service;

import java.util.List;

import com.wqc.pojo.Users;

public interface UsersService {
	void addUser(Users users);
	
	List<Users> findUserAll();
	
	Users findUsersById(Integer id);
	
	void updateUser(Users users);
	
	void deleteUserById(Integer id);
	
	void addAdms(Users users);
}

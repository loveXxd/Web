package com.wqc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wqc.mapper.UsersMapper;
import com.wqc.pojo.Users;
import com.wqc.service.UsersService;

@Service
@Transactional
public class UserServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public void addUser(Users users) {
		// TODO Auto-generated method stub
		this.usersMapper.insertUser(users);

	}
	
	@Override
	public List<Users> findUserAll() {
		// TODO Auto-generated method 
		return this.usersMapper.selectUserAll();
	}

	@Override
	public Users findUsersById(Integer id) {
		// TODO Auto-generated method stub
		return this.usersMapper.selectUsersById(id);
	}

	@Override
	public void updateUser(Users users) {
		// TODO Auto-generated method stub
		this.usersMapper.updataUser(users);
		
	}

	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		this.usersMapper.deleteUserById(id);
	}

	@Override
	public void addAdms(Users users) {
		// TODO Auto-generated method stub
		this.usersMapper.insertAdms(users);
	}

}

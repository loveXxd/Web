package com.wqc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wqc.pojo.Users;

public interface UsersService {

	List<Users> findUSersAll();
	Users findUserById(Integer id);
	Page<Users> findUsersByPage(Pageable pageable);
	void saveUsers(Users users);
}

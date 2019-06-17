package com.wqc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wqc.dao.UsersDaoImpl;

@Service
public class UsersServiceImpl {

	@Autowired
	private UsersDaoImpl usersDaoImpl;
	public void addUSers() {
		this.usersDaoImpl.saveUSer();
	}
}

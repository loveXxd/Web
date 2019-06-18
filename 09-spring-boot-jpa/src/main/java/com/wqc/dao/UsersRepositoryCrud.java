package com.wqc.dao;

import org.springframework.data.repository.CrudRepository;

import com.wqc.pojo.Users;

public interface UsersRepositoryCrud extends CrudRepository<Users, Integer> {

}

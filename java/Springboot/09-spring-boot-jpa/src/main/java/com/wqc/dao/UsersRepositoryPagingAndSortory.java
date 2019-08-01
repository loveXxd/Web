package com.wqc.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wqc.pojo.Users;

public interface UsersRepositoryPagingAndSortory extends PagingAndSortingRepository<Users, Integer> {

}

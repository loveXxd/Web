package com.wqc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wqc.dao.UsersRepository;
import com.wqc.pojo.Users;
import com.wqc.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	@Cacheable(value="users")
	public List<Users> findUSersAll() {
		// TODO Auto-generated method stub
		return this.usersRepository.findAll();
	}

	@Override
	//对当前的对象对缓存处理  根据value 匹配xml缓存策略 而且必须实现可序列化接口 key在缓存中存储的对象
	@Cacheable(value="users")
	public Users findUserById(Integer id) {
		// TODO Auto-generated method stub
		return this.usersRepository.findOne(id);
	}

	@Override
	@Cacheable(value="users",key="#pageable.pageSize")// key在缓存中存储的对象 缓存中有直接取没有的话查询
	public Page<Users> findUsersByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.usersRepository.findAll(pageable);
	}

	@Override
	//清楚缓存中value=”users“的对象
	@CacheEvict(value="users",allEntries=true)
	public void saveUsers(Users users) {
		// TODO Auto-generated method stub
		this.usersRepository.save(users);

	}

}

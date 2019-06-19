package com.wqc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wqc.pojo.Users;
/**
 * 参数1 当前映射的实体类
 * 参数2 当前映射的oid的类型
 * @author Administrator
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {

}

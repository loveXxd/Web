package com.wqc.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.dom4j.CDATA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wqc.App;
import com.wqc.dao.UsersRepository;
import com.wqc.dao.UsersRepositoryByName;
import com.wqc.dao.UsersRepositoryCrud;
import com.wqc.dao.UsersRepositoryPagingAndSortory;
import com.wqc.dao.UsersRepositoryQueryAnnotation;
import com.wqc.dao.UsersRepositorySpecification;
import com.wqc.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class test {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UsersRepositoryByName UsersRepositoryByName;
	
	@Autowired
	private UsersRepositoryQueryAnnotation UsersRepositoryQueryAnnotation;
	
	@Autowired
	private UsersRepositoryCrud UsersRepositoryCrud;
	
	@Autowired
	private UsersRepositoryPagingAndSortory UsersRepositoryPagingAndSortory;
	
	
	@Autowired
	private UsersRepositorySpecification usersRepositorySpecification;
	
	@Test
	public void test() {
		Users users=new Users();
		users.setAddres("杭州");
		users.setAge(66);
		users.setName("李白");
		this.usersRepository.save(users);
	}
	
	@Test
	public void findbyname() {
		List<Users> list= this.UsersRepositoryByName.findByName("张三");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	@Test
	public void findbynamelike() {
		List<Users> list= this.UsersRepositoryByName.findByNameLike("%张%");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	//分页+排序
	@Test
	public void findalljpapagsort() {
		//pageable定义分页规则 当前页码(从零开始)  显示条数 
		//是个接口 要是PageRequest  page是当前页码 size为一页的条数
		//order定义排序规则
		Order order =new Order(Direction.DESC,"id");
		//sort对象封装了排序规则
		Sort sort= new Sort(order);
		Pageable pageable =new PageRequest(0,2,sort);
		Page<Users> page=this.usersRepository.findAll(pageable);
		System.out.println("总条数"+page.getTotalElements()+"总页数"+page.getTotalPages());
		for (Users users2 : page) {
			System.out.println(users2);
		}
	}
	
	@Test
	public void findbynameQuery1() {
		List<Users> list= this.UsersRepositoryQueryAnnotation.queryByNameHQL("张三");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	@Test
	public void findbynameQuery2() {
		List<Users> list= this.UsersRepositoryQueryAnnotation.queryByNameSQL("张三");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	@Test
	@Transactional //@Transactional与@Test一起使用是事件会回滚
	@Rollback(false) //防止事件 回滚
	public void findbynameQuery3() {
		this.UsersRepositoryQueryAnnotation.updateUSersNameById("张三三", 2);
	}
	
	@Test
	public void add() {
		Users users=new Users();
		users.setAddres("贵阳");
		users.setAge(61);
		users.setName("牡丹");
		this.UsersRepositoryCrud.save(users);
	}
	
	@Test
	public void find() {
		Users users=new Users();
		users.setAddres("贵阳");
		users.setAge(61);
		users.setName("牡丹");
		this.UsersRepositoryCrud.save(users);
	}
	//排序测试
	@Test
	public void findallsort() {
		//order定义排序规则
		Order order =new Order(Direction.DESC,"id");
		//sort对象封装了排序规则
		Sort sort= new Sort(order);
		List<Users> users=(List<Users>)this.UsersRepositoryPagingAndSortory.findAll(sort);
		for (Users users2 : users) {
			System.out.println(users2);
		}
	}
	//分页测试
		@Test
		public void findallpag() {
			//pageable定义分页规则 当前页码(从零开始)  显示条数 
			//是个接口 要是PageRequest  page是当前页码 size为一页的条数
			Pageable pageable =new PageRequest(0,2);
			Page<Users> page=this.UsersRepositoryPagingAndSortory.findAll(pageable);
			System.out.println("总条数"+page.getTotalElements()+"总页数"+page.getTotalPages());
			for (Users users2 : page) {
				System.out.println(users2);
			}
		}
		
		//分页+排序
		@Test
		public void findallpagsort() {
			//pageable定义分页规则 当前页码(从零开始)  显示条数 
			//是个接口 要是PageRequest  page是当前页码 size为一页的条数
			//order定义排序规则
			Order order =new Order(Direction.DESC,"id");
			//sort对象封装了排序规则
			Sort sort= new Sort(order);
			Pageable pageable =new PageRequest(0,2,sort);
			Page<Users> page=this.UsersRepositoryPagingAndSortory.findAll(pageable);
			System.out.println("总条数"+page.getTotalElements()+"总页数"+page.getTotalPages());
			for (Users users2 : page) {
				System.out.println(users2);
			}
		}
		
		//分页+排序
		@Test
		public void findallpagsortspecification() {
			/**
			 * Specification<Users> spec封装查询条件
			 * Predicate 单个的查询条件
			 * Root<Users> root 查询对象属性封装
			 * CriteriaQuery<?> query 查询部位信息 from select。。。。
			 * CriteriaBuilder cb查询构造器 定义不同查询条件
			 */
			Specification<Users> spec = new Specification<Users>() {

				@Override
				public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					/**
					 * 参数1 查询条件属性
					 * 参数2 查询的值
					 */
					//Predicate pre=cb.equal(root.get("name"), "张三三");
					List<Predicate> list=new ArrayList<Predicate>();
					list.add(cb.equal(root.get("name"), "张三三"));
					list.add(cb.equal(root.get("age"), 22));
					Predicate []arr=new Predicate[list.size()];
					cb.or(cb.and(cb.equal(root.get("name"), "张三三"),cb.equal(root.get("age"), 22)));
					return cb.and(list.toArray(arr));
				}
			
			};
			
			List<Users> page=this.usersRepositorySpecification.findAll(spec);
			for (Users users2 : page) {
				System.out.println(users2);
			}
		}
			
		
	
}

package com.wqc.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_roles")
public class Roles {

	
	//实现角色管理
	//比如用户权限管理 多用户对应一个管理权限
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleid")
	private Integer roleid;
	
	@Column(name="rolename")
	private String rolename;
	
	@OneToMany(mappedBy="roles")
	private Set<Users> users=new HashSet<>();

	//加,fetch=FetchType.EAGER生成长期sessions
	@ManyToMany(cascade=CascadeType.PERSIST)
	//@JoinTable 映射中间表名 两侧任何一侧添加都可以
	//joinColumns 当前主键关联的中间表中的外键字段名称
	@JoinTable(name="t_roles_menus",joinColumns=@JoinColumn(name="role_id"),inverseJoinColumns=@JoinColumn(name="menu_id"))
	private Set<Menus> menus=new HashSet<>();
	
	
	
	public Set<Menus> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menus> menus) {
		this.menus = menus;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	
	
	
	
}

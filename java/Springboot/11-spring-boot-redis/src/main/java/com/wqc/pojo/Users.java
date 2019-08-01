package com.wqc.pojo;

import java.io.Serializable;

public class Users implements Serializable {

	private String name;
	private Integer age;
	private Integer id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
}

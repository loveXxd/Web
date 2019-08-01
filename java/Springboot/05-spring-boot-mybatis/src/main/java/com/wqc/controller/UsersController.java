package com.wqc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wqc.pojo.Users;
import com.wqc.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService  usersService;
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	/**
	 * @ModelAttribute("users") 页面返回错误对象命名首字母必须小写
	 * @param users
	 * @return
	 */
	@RequestMapping("/login")
	public String login1(@ModelAttribute("usersAll") Users users) {
		return "login";
	}
	/**
	 * 
	 * @Valid 对数据校验
	 * BindingResult 封装了校验结果
	 * @param users
	 * @return
	 */
	@RequestMapping("/login1")
	public String login1(@ModelAttribute("usersAll") @Valid Users users,BindingResult result) {
		if(result.hasErrors()) {
			return "login";
		}
		this.usersService.addAdms(users);
		return "login";
	}
	
	
	@RequestMapping("/addUser")
	public String addUser(Users users) {
		this.usersService.addUser(users);
		return "ok";
	}
	@RequestMapping("/findUserAll")
	public String findUserAll(Model model) {
		List<Users> list= this.usersService.findUserAll();
		model.addAttribute("list",list);
		return "showUsers";
	}
	@RequestMapping("/findUserById")
	public String findUserById(Integer id, Model model) {
		Users user= this.usersService.findUsersById(id);
		model.addAttribute("user",user);
		return "updataUser";
	}
	
	@RequestMapping("/editUser")
	public String updateUser(Users user) {
		this.usersService.updateUser(user);
		return "ok";
	}
	@RequestMapping("/deleteUser")
	public String deleteUserById(Integer id,Model model) {
		this.usersService.deleteUserById(id);
		return "redirect:/users/findUserAll";
	}
}

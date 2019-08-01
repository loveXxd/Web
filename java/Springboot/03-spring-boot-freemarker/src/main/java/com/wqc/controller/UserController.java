package com.wqc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wqc.pojo.Users;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class UserController {
	@RequestMapping("/showUser")
	public String showUser(Model model) {
		List<Users> list = new ArrayList<Users>();
		list.add(new Users(1,"张三",20));
		list.add(new Users(2,"李四",22));
		list.add(new Users(3,"王五",21));
		model.addAttribute("list",list);
		return "userList";
	}
}

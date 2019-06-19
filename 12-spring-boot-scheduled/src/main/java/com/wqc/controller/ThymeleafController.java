package com.wqc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import groovy.lang.Newify;

@Controller
public class ThymeleafController {

	@RequestMapping("/index.html")
	public String showInfo(Model model) {
		model.addAttribute("msg", "Thymeleaf 案例");
		model.addAttribute("time", new Date());
		return "index";
	}
}

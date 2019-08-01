package com.wqc.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class HlloWorld {
	@RequestMapping("/hello")
	@ResponseBody
	public Map<String,Object> showHellWorld() {
		Map<String, Object>map=new HashMap<>();
		map.put("msg", "helloword");
		return map;
	}
}

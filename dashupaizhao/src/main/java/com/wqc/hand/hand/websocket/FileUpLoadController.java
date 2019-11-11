package com.wqc.hand.hand.websocket;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wqc.hand.hand.util.dianzan;


/**
 * spring boot 文件上传
 * @author Administrator
 *
 */
@RestController //标示该类下的返回值会进行json转换
public class FileUpLoadController {
	@RequestMapping("/getweixin")
	public String getdianzannum() {
		System.out.println(":11111111");
		return "1111111111";
		
	}
	
	@RequestMapping("/getfileimg")
	public HashMap<String ,String> fileUpload(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		dianzan.addcontwrite(request);
		String imgstr = request.getParameter("imgstr");
		String cont = request.getParameter("cont");
		System.out.println(name);
		//filename.transferTo(new File("e:/"+filename.getOriginalFilename()));
		//r     Base64Convert.GenerateImage(method, "1111");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("imgstr", imgstr);
		map.put("cont", cont);
		return map;
	}
	
	
}

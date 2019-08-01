package com.wqc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * spring boot 文件上传
 * @author Administrator
 *
 */
@RestController //标示该类下的返回值会进行json转换
public class FileUpLoadController {
	@RequestMapping("/fileUplodController")
	public Map<String, Object> fileUpload(MultipartFile filename) throws IOException {
		filename.transferTo(new File("e:/"+filename.getOriginalFilename()));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "ok");
		return map;
	}
}

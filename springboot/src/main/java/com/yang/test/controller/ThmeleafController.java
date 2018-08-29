package com.yang.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThmeleafController {
	
	@RequestMapping(method = RequestMethod.GET,value = "/index3")
	public String index(ModelMap map){
		
		map.put("host", "www.baidu.com");
		
		return "index";
	}
}

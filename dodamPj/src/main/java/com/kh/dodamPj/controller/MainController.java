package com.kh.dodamPj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/main")
public class MainController {
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() throws Exception {
		return "/main/main";
	}
}

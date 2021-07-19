package com.kh.dodamPj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/adopt")
public class AdoptController {

	@RequestMapping(value="/adoptInfo", method=RequestMethod.GET)
	public String adoptInfo() throws Exception {
		return "adopt/adoptInfo";
	}
	
	@RequestMapping(value="/applyAdopt", method=RequestMethod.GET)
	public String applyAdopt() throws Exception {
		return "adopt/applyAdopt";
	}
	
}

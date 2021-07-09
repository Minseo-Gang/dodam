package com.kh.dodamPj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/loseAnimal")
public class LoseAnimalController {

	
	@RequestMapping(value="/infoGetAnimal", method=RequestMethod.GET)
	public String infoGetAnimal() throws Exception {
		return "/loseAnimal/infoGetAnimal";
	}
	
	@RequestMapping(value="/reportAnimal", method=RequestMethod.GET)
	public String reportAnimal() throws Exception {
		return "/loseAnimal/reportAnimal";
	}
}

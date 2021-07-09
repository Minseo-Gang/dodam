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
	
	@RequestMapping(value="/reportList", method=RequestMethod.GET)
	public String reportList() throws Exception {
		return "/loseAnimal/reportAnimal";
	}
	
	@RequestMapping(value="/reportAnimalForm", method=RequestMethod.GET)
	public String reportAnimalForm() throws Exception {
		return "/loseAnimal/reportAnimalForm";
	}
	
	@RequestMapping(value="/reportAnimalRun", method=RequestMethod.POST)
	public String reportAnimalRun() throws Exception {
		return "redirect:/loseAnimal/reportAnimal";
	}
}

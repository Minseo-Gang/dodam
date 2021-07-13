package com.kh.dodamPj.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.LostService;
import com.kh.dodamPj.vo.LostVo;

@Controller
@RequestMapping(value="/lostAnimal")
public class LostAnimalController {
	
	@Inject
	private LostService lostService;

	@RequestMapping(value="/infoGetAnimal", method=RequestMethod.GET)
	public String infoGetAnimal() throws Exception {
		return "lostAnimal/infoGetAnimal";
	}
	
	@RequestMapping(value="/reportList", method=RequestMethod.GET)
	public String reportList(Model model) throws Exception {
		List<LostVo> list = lostService.reportList();
		model.addAttribute("list", list);
		return "lostAnimal/reportAnimal";
	}
	
	@RequestMapping(value="/reportAnimalForm", method=RequestMethod.GET)
	public String reportAnimalForm() throws Exception {
		return "lostAnimal/reportAnimalForm";
	}
	
	@RequestMapping(value="/reportRun", method=RequestMethod.POST)
	public String reportRun(LostVo lostVo, RedirectAttributes rttr) throws Exception {
		lostService.reportRun(lostVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/lostAnimal/reportList";
	}
	
	@RequestMapping(value="/reportContent", method=RequestMethod.GET)
	public String reportContent(Model model, int b_no) throws Exception {
		LostVo lostVo = lostService.reportContent(b_no);
		model.addAttribute("lostVo", lostVo);
		return "lostAnimal/reportContent";
	}
	
	@RequestMapping(value="/reportModifyRun", method=RequestMethod.POST)
	public String reportModifyRun(LostVo lostVo, RedirectAttributes rttr) throws Exception {
		lostService.reportModifyRun(lostVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/lostAnimal/reportContent?b_no=" + lostVo.getB_no();
	}
	
	@RequestMapping(value="/reportDeleteRun", method=RequestMethod.GET)
	public String reportDeleteRun(int b_no) throws Exception {
		lostService.reportDeleteRun(b_no);
		return "redirect:/lostAnimal/reportList";
	}
	
	@RequestMapping(value="/protectAnimal", method=RequestMethod.GET)
	public String protectAnimal() throws Exception {
		return "lostAnimal/protectAnimal";
	}
	
	@RequestMapping(value="/protectAnimalCont", method=RequestMethod.GET)
	public String protentAnimalContent() throws Exception {
		return "lostAnimal/protectAnimalCont";
	}
}

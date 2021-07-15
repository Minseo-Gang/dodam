package com.kh.dodamPj.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.VolunteerService;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

@Controller
@RequestMapping(value="/volunteer")
public class VolunteerController {

	@Inject
	private VolunteerService volunteerService;
	
	@RequestMapping(value="/reservation", method=RequestMethod.GET)
	public String reservation() throws Exception {
		return "volunteer/reservation";
	}
	
	@RequestMapping(value="/reservationForm", method=RequestMethod.GET)
	public String reservationForm() throws Exception {
		return "volunteer/reservation_form";
	}

	@RequestMapping(value="/volunReservList", method=RequestMethod.GET)
	public String volunReservList(Model model, PagingDto pagingDto) throws Exception {
		int count = volunteerService.getCount(pagingDto);
		pagingDto.setCount(count);
		System.out.println("pagingDto:" + pagingDto);
		List<VolunteerVo> list = volunteerService.volunReservList(pagingDto);
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", pagingDto);
		System.out.println("list : " + list);
		return "volunteer/reservation_status";	
	}
	
	@RequestMapping(value="/reservVolun", method=RequestMethod.POST)
	public String reservVolun(VolunteerVo volunteerVo, RedirectAttributes rttr) throws Exception {
		volunteerService.reservVolun(volunteerVo);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/volunteer/volunReservList";
	} 
	

}
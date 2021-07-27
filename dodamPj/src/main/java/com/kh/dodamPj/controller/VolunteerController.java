package com.kh.dodamPj.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.MemberService;
import com.kh.dodamPj.service.VolunteerService;
import com.kh.dodamPj.vo.MemberVo;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

@Controller
@RequestMapping(value="/volunteer")
public class VolunteerController {

	@Inject
	private VolunteerService volunteerService;
	@Inject
	private MemberService MemberService;
	
	@RequestMapping(value="/reservationForm", method=RequestMethod.GET)
	public String reservationForm() throws Exception {
		return "volunteer/reservation_form";
	}
	
	// 나의 예약 정보
	@RequestMapping(value="/myReservation", method=RequestMethod.GET)
	public String myReservation() throws Exception {
		return "volunteer/my_reservation";
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
	
//	@RequestMapping(value="/reservVolun", method=RequestMethod.POST)
//	@ResponseBody
//	public String reservVolun(@RequestBody VolunteerVo volunteerVo, 
//			HttpSession session) throws Exception {
//		MemberVo memberVo = (MemberVo)session.getAttribute("loginVo");
//		volunteerVo.setUser_id(memberVo.getUser_id());
//		System.out.println(volunteerVo);
//		volunteerService.reservVolun(volunteerVo);
//		return "redirect:/volunteer/reservation_status";
//	} 
//	
	@RequestMapping(value="/reservVolun", method=RequestMethod.POST)
	public String reservVolun(VolunteerVo volunteerVo, RedirectAttributes rttr) throws Exception {
		volunteerService.reservVolun(volunteerVo);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/volunteer/volunReservList";
	} 
	
	@RequestMapping(value="/checkDateAndTime", method=RequestMethod.GET)
	@ResponseBody
	public String checkDateAndTime(VolunteerVo volunteerVo, RedirectAttributes rttr) throws Exception {
		boolean result = volunteerService.checkDateAndTime(volunteerVo);
		System.out.println("result : " + result);
		if(result == false) {
			
		}
		return String.valueOf(result);
	}
	

}

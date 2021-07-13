package com.kh.dodamPj.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.AdminService;
import com.kh.dodamPj.service.BoardService;
import com.kh.dodamPj.service.MemberService;
import com.kh.dodamPj.service.NoticeService;
import com.kh.dodamPj.vo.NoticeVo;
import com.kh.dodamPj.vo.PagingDto;

@Controller
@RequestMapping(value="/admin")
public class amdinController {
	
	@Inject
	private AdminService adminService;
	@Inject
	private BoardService boardService;
	
	@Inject
	private NoticeService noticeService;
	
	@Inject
	private MemberService memberService;
	
	// 관리자 페이지로 이동 요청 오면 관리자 페이지로 이동 
	@RequestMapping(value="/adminPage",method=RequestMethod.GET)
	public String adminPage(NoticeVo noticeVo,Model model,PagingDto pagingDto) throws Exception{
		//공지 사항 리스트 붙혀서 이동
		List<NoticeVo> list = noticeService.listAll(pagingDto);
		model.addAttribute("noticeList", list);
		return "/admin/adminPage"; 
		
	}
	
		// 로그아웃 하는거
		@RequestMapping("/logout")
	    public String logout(HttpSession session,RedirectAttributes rttr) {
	        session.invalidate();
	        return "redirect:/"; // 로그아웃을 누르면 mainPage.jsp로 리다이렉트
	    }
}

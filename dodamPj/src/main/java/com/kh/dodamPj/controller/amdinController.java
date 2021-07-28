package com.kh.dodamPj.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.AdminService;
import com.kh.dodamPj.service.BoardService;
import com.kh.dodamPj.service.MemberService;
import com.kh.dodamPj.service.NoticeService;
import com.kh.dodamPj.service.VolunteerService;
import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.NoticeVo;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

@Controller
@RequestMapping(value="/admin")
public class amdinController {
	
	@Inject
	private AdminService adminService;
	@Inject
	private BoardService boardSerivce;
	
	@Inject
	private NoticeService noticeService;
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private VolunteerService volunteerService;

	
	// 관리자 페이지로 이동 요청 오면 관리자 페이지로 이동 
	@RequestMapping(value="/adminPage",method=RequestMethod.GET)
	public String adminPage(NoticeVo noticeVo,Model model,PagingDto pagingDto) throws Exception{
		//공지 사항 리스트 붙혀서 이동
		List<NoticeVo> list = noticeService.listAll(pagingDto);
		
		model.addAttribute("noticeList", list);
		
		return "/admin/adminPage"; 
		
	}
	//회원 관리 페이지인데 나중에 동물 등록으로 변경
	@RequestMapping(value = "/adminFreeBoard", method = RequestMethod.GET)
	public String adminForeeBoard(Model model,PagingDto pagingDto) throws Exception {
		int count = boardSerivce.getCount(pagingDto);
		pagingDto.setCount(count);
		String key = pagingDto.getKeyword();
		System.out.println("key: "+ key);
		List<BoardVo> list = boardSerivce.freeBoard(pagingDto); 
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", pagingDto);
		return "/admin/adminFreeBoard";

	}
	//관리자 페이지 자유게시판 게시글 삭제 (비동기)21-07-22
	@RequestMapping(value="/adminDeleteRun", method=RequestMethod.GET)
	@ResponseBody
	public String deleteRun(int b_no) throws Exception { // 글삭제
		boardSerivce.deleteRun(b_no);
		return "success";
	}
	// 봉사활동 리스트 보기 : 관리자 페이지 --2021-07-19
	@RequestMapping(value = "/adminReservation_status", method = RequestMethod.GET)
	public String adminReservation_status(Model model,PagingDto pagingDto) throws Exception {
		List<VolunteerVo> volunList = volunteerService.volunReservList(pagingDto);		
		model.addAttribute("volunList", volunList);
		return "/admin/adminReservation_status";

	}
	
	//봉사활동 승인 and 거부 하기 : 비동기로 처리 --2021-07-19 : 봉사활동 테이블에 result 컬럼 추가 
	@RequestMapping(value = "/adminReservation_statusUpdate", method = RequestMethod.GET)
	@ResponseBody
	public String adminReservation_statusUpdate(VolunteerVo volunteer,Model model,PagingDto pagingDto) throws Exception {
				
				
				volunteerService.resultInsert(volunteer);
				
		return "success";

	}
	
		// 로그아웃 하는거
		@RequestMapping("/logout")
	    public String logout(HttpSession session,RedirectAttributes rttr) {
	        session.invalidate();
	        return "redirect:/"; // 로그아웃을 누르면 mainPage.jsp로 리다이렉트
	    }
}

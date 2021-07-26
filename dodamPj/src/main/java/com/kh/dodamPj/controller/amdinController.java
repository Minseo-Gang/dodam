package com.kh.dodamPj.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.AdminService;
import com.kh.dodamPj.service.BoardService;
import com.kh.dodamPj.service.CustomerBoardService;
import com.kh.dodamPj.service.NoticeService;
import com.kh.dodamPj.service.VolunteerService;
import com.kh.dodamPj.service.NewsBoardService;
import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.CustomerBoardVo;
import com.kh.dodamPj.vo.MemberVo;
import com.kh.dodamPj.vo.NoticeVo;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;
import com.kh.dodamPj.vo.NewsBoardVo;


@Controller
@RequestMapping(value="/admin")
public class amdinController {
	
	@Inject
	private AdminService adminService;
	
	@Inject
	private NoticeService noticeService;
	
	@Inject
	private CustomerBoardService customerBoardService;
	
	@Inject
	private VolunteerService volunteerService;
	
	@Inject
	private NewsBoardService newsBoardSerivce;
	
	@Inject
	private BoardService boardSerivce;

	
	// 관리자 페이지로 이동 요청 오면 관리자 페이지로 이동 
	@RequestMapping(value="/adminPage",method=RequestMethod.GET)
	public String adminPage(NoticeVo noticeVo,Model model,PagingDto pagingDto) throws Exception{
		//공지 사항 리스트 붙혀서 이동
		List<NoticeVo> list = noticeService.listAll(pagingDto);
		
		model.addAttribute("noticeList", list);
		
		return "/admin/adminPage"; 
		
	}
	//회원 관리 페이지인데 나중에 동물 등록으로 변경
	@RequestMapping(value = "/memberManagement", method = RequestMethod.GET)
	public String memberManagement(Model model) throws Exception {
		List<MemberVo> memberList = adminService.listMember();
		model.addAttribute("memberList", memberList);
		return "/admin/memberManagement";

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

	// 관리자 페이지 고객센터
	@RequestMapping(value = "/adminCustomerBoard", method = RequestMethod.GET)
	public String adminCustomerBoard(Model model,PagingDto pagingDto) throws Exception {
		int count = customerBoardService.getCount(pagingDto);
		pagingDto.setCount(count);
		List<CustomerBoardVo> list = customerBoardService.customerBoard(pagingDto); 
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", pagingDto);
		return "/admin/adminCustomerBoard";
	}
	
	// 고객센터 내용보기
	@RequestMapping(value = "/adminCustomerContent", method=RequestMethod.GET)
	public String adminCustomerContent(int cb_no, Model model) throws Exception {
		CustomerBoardVo customerBoardVo = customerBoardService.content(cb_no);
		model.addAttribute("customerBoardVo", customerBoardVo);
		return "admin/adminCustomerContent";
	}
	
	// 고객센터 답글달기
	@RequestMapping(value="/adminCustomerReplyForm", method=RequestMethod.GET)
	public String adminCustomerReplyForm(int cb_no,Model model) throws Exception { // 답글폼
		CustomerBoardVo customerBoardVo = customerBoardService.content(cb_no);
		customerBoardVo.setRe_group(cb_no);
		model.addAttribute("customerBoardVo", customerBoardVo);
		return "admin/adminCustomerReplyForm"; 
	}
	
	@RequestMapping(value="/adminCustomerReplyRun", method=RequestMethod.POST)
	public String adminCustomerReplyForm(CustomerBoardVo customerBoardVo) throws Exception { // 답글폼 -> 문의게시판
		customerBoardService.replyWriteRun(customerBoardVo);
		return "redirect:/admin/adminCustomerBoard";
	}
	
	// 고객센터 답글보기
	@RequestMapping(value="/adminCustomerReplyContent", method=RequestMethod.GET)
	public String adminCustomerReplyContent(int cb_no, Model model) throws Exception {
		CustomerBoardVo customerBoardVo = customerBoardService.content(cb_no);
		model.addAttribute("customerBoardVo", customerBoardVo);
		return "admin/adminCustomerReplyContent";
	}
	
	// 고객센터 글삭제
	@RequestMapping(value="/adminCustomerDeleteRun", method=RequestMethod.GET)
	public String adminCustomerDeleteRun(int cb_no) throws Exception { // 글삭제
		customerBoardService.deleteRun(cb_no);
		return "redirect:/admin/adminCustomerBoard";
	}
	
	
	// 동물게시판 리스트
	@RequestMapping(value="/adminNewsBoard", method=RequestMethod.GET)
	public String newsBoard(Model model, PagingDto pagingDto) throws Exception { // 동물게시판
		int count = newsBoardSerivce.getCount(pagingDto);
		pagingDto.setCount(count);
		List<NewsBoardVo> list = newsBoardSerivce.newsBoard(pagingDto); 
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", pagingDto);
		return "admin/adminNewsBoard";
	}
	
	// 동물게시판 글쓰기
	@RequestMapping(value="/adminNewsBoardWriteForm", method=RequestMethod.GET)
	public String adminNewsBoardWriteForm() throws Exception { // 글쓰기폼
		return "admin/adminNewsBoardWriteForm"; 
	}
	
	// 동물게시판 글삭제
	@RequestMapping(value="/adminNewsBoardDeleteRun", method=RequestMethod.GET)
	public String adminNewsBoardDeleteRun(int ab_no) throws Exception { // 글삭제
		newsBoardSerivce.deleteRun(ab_no);
		return "redirect:/admin/adminNewsBoard";
	}
	
	@RequestMapping(value="/adminNewsBoardWriteRun", method=RequestMethod.POST)
	public String adminNewsBoardWriteRun(NewsBoardVo newsBoardVo) throws Exception { // 글쓰기폼->자유게시판
		newsBoardSerivce.writeRun(newsBoardVo);
		String name = newsBoardVo.getUser_id();
		System.out.println("newsBoardVo "+ newsBoardVo);
		System.out.println("name " + name);
		return "redirect:/admin/adminNewsBoard";
	}
	
	// 동물게시판 글수정
	@RequestMapping(value="/adminNewsBoardModifyForm", method=RequestMethod.GET)
	public String modifyForm(int ab_no, Model model) throws Exception { // 수정폼
		NewsBoardVo newsBoardVo = newsBoardSerivce.content(ab_no);
		model.addAttribute("newsBoardVo", newsBoardVo);
		return "admin/adminNewsBoardModifyForm"; 
	}
	
	@RequestMapping(value="/adminNewsBoardModifyRun", method=RequestMethod.POST)
	public String modifyRun(NewsBoardVo newsBoardVo) throws Exception { // 수정폼->동물게시판
		newsBoardSerivce.modifyRun(newsBoardVo);
		return "redirect:/admin/adminNewsBoard";
	}
	
	// 동물게시판 상세보기
	@RequestMapping(value="/adminNewsBoardContent", method=RequestMethod.GET)
	public String adminNewsBoardContent(int ab_no, Model model) throws Exception {
		NewsBoardVo newsBoardVo = newsBoardSerivce.content(ab_no);
		model.addAttribute("newsBoardVo", newsBoardVo);
		return "admin/adminNewsBoardContent";
	}
	
	// 관리자 페이지 자유게시판
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
 
 	// 관리자 자유게시판 상세
 	@RequestMapping(value="/adminFreeBoardContent", method=RequestMethod.GET)
 	public String adminFreeBoardContent(int b_no, Model model) throws Exception {
 		BoardVo boardVo = boardSerivce.content(b_no);
 		model.addAttribute("boardVo", boardVo);
 		return "admin/adminFreeBoardContent";
 	}
 	
	//관리자 페이지 자유게시판 게시글 삭제 (비동기)21-07-22
	@RequestMapping(value="/adminDeleteRun", method=RequestMethod.GET)
	public String deleteRun(int b_no) throws Exception { // 글삭제
		boardSerivce.commentDeleteRun(b_no);
		boardSerivce.deleteRun(b_no);
		return "redirect:/admin/adminFreeBoard";
	}

	// 로그아웃 하는거
	@RequestMapping("/logout")
    public String logout(HttpSession session,RedirectAttributes rttr) {
        session.invalidate();
        return "redirect:/"; // 로그아웃을 누르면 mainPage.jsp로 리다이렉트
    }
}

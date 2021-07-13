package com.kh.dodamPj.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.BoardService;
import com.kh.dodamPj.service.MemberService;
import com.kh.dodamPj.vo.MemberVo;


@Controller
@RequestMapping(value = "/user")
public class MemberController {
	@Inject
	private MemberService memberService;
	@Inject
	private BoardService boardService;
	
	// 로그인 페이지로 이동
	@RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
	public String memberLogin() throws Exception {

		return "/user/memberLogin";

	}
	

	// 회원가입 폼으로 이동
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm() throws Exception {

		return "/user/joinForm";

	}
	//아이디 찾기 폼으로 이동
	@RequestMapping(value = "/findId", method = RequestMethod.GET)
	public String findId() throws Exception {

		return "/user/findId";

	}
	//패스워드 찾기 폼으로 이동
	@RequestMapping(value = "/findPw", method = RequestMethod.GET)
	public String findPw() throws Exception {

		return "/user/findPw";

	}

	// 회원가입 처리
	@RequestMapping(value = "/joinRun", method = RequestMethod.POST)
	public String joinRun(MemberVo memberVo, RedirectAttributes rttr) throws Exception {
		memberService.joinRun(memberVo);
		System.out.println("Join MemeberVo: "+memberVo);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/";

	}

	// 로그아웃 처리
	@RequestMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		session.invalidate();
		return "redirect:/"; // 로그아웃을 누르면 mainPage.jsp로 리다이렉트
	}

	// 아이디 중복 확인
	@RequestMapping(value = "/checkDupId", method = RequestMethod.GET)
	@ResponseBody
	public String checkDupId(String user_id) throws Exception {
		boolean result = memberService.checkDupId(user_id);
		return String.valueOf(result);
	}

	// 아이디 찾기
	@RequestMapping("/findIdRun")
	@ResponseBody
	public String findId(String user_name, String phoneNum,Model model,RedirectAttributes rttr)throws Exception  {
			String user_id = null;
			MemberVo memberVo = memberService.findId(user_name, phoneNum);
			String name = memberVo.getUser_id();
			user_id = name;

		rttr.addFlashAttribute("msg", "success");
		return user_id; // 
	}

	// 패스워드 찾기
	@RequestMapping("/findPwRun")
	@ResponseBody
	public MemberVo findPw(String user_id, String user_name, String phoneNum,Model model) {
		MemberVo memberVo = memberService.findPw(user_id, user_name, phoneNum);
		model.addAttribute(memberVo);
		return memberVo; // 
	}

}

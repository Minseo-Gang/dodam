
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
	
	/* NaverLoginBO */ //이거 안씀 네이버 api
//	private NaverLoginBo naverLoginBO;
//	private String apiResult = null;

	// 로그인 페이지로 이동
	@RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
	public String memberLogin() throws Exception {

		return "/user/memberLogin";

	}
	
	//----------------------네이버 api 안씀------------------------
//	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
//	public String naverLogin(Model model, HttpSession session) {
//		
//		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
//		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
//		
//		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
//		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
//		System.out.println("네이버:" + naverAuthUrl);
//		
//		//네이버 
//		model.addAttribute("url", naverAuthUrl);
//
//		/* 생성한 인증 URL을 View로 전달 */
//		return "/user/login";
//	}
	//----------------------네이버 api 안씀------------------------
	
	
	// 메인 페이지 이동 안씀*
//	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
//	public String main() throws Exception {
//
//		return "/member/mainPage";
//
//	}

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
		return "redirect:/user/memberLogin";

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

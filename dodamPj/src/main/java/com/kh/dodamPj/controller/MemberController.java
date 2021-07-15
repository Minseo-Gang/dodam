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
	
	// 마이페이지 21.07.14
//		@RequestMapping(value = "/myPage", method = RequestMethod.GET)
//		public String myPage(String user_id,Model model) throws Exception {
//			System.out.println("user_id: "+user_id);
//			MemberVo memberVo = memberService.selectMember(user_id);
//			model.addAttribute("memberVo", memberVo);
//			return "/user/myPage";
//
//		}
		
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
	// 로그인 처리 (관리자 로그인 포함)
			@RequestMapping(value="/memberLoginRun",method=RequestMethod.POST)
			public String loginRun(String user_id, String user_pw ,RedirectAttributes rttr,HttpSession session) throws Exception{
				MemberVo memberVo = memberService.login(user_id, user_pw);
				
				System.out.println("memberVo "+memberVo);
				rttr.addFlashAttribute("msgLogin", "success");
				System.out.println("id "+user_id);
				System.out.println("pw "+user_pw);
				String msg = null;
			 	String page = null;
			 	//Vo에 정보 확인후 널값이 아니면 메인 화면으로 이동
			 	if (memberVo != null) {
			 		msg = "success";
			 		
			 		int level = memberVo.getAuth_level(); // memberVo에 관리자 레벨 0 , 1 확인용
			 			//관리자 레벨이 1이면 관리자 페이지로 이동
			 		if(level==1) {
			 			
			 			//인터 셉트 걸릴수도 있으니 걸리면 서블릿 컨텍스트에 path 확인해보고 리디렉션횟수 많다고 뜨면 매핑 이름 변경
			 			session.setAttribute("adminLoginVo", memberVo);
			 			page = "redirect:/admin/adminPage";
			 		} else {
			 			
			 			session.setAttribute("loginVo", memberVo);
			 			page = "redirect:/";
			 		}
			 	} else {
			 		//Vo에 로그인 정보가 없으면 로그인 페이지로 리디렉션
			 		msg = "fail";
			 		page = "redirect:/user/memberLogin";
			 	}
			 	rttr.addFlashAttribute("msg", msg);
				return page; // 로그인이 되면 home.jsp로 리다이렉트
				
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
	
	//패스워드 수정 21-07-14
	@RequestMapping(value = "/updatePw", method = RequestMethod.POST)
	public String updatePw(MemberVo memberVo, RedirectAttributes rttr) throws Exception {
		memberService.updatePw(memberVo);
		System.out.println("updatePw MemeberVo: "+memberVo);
		rttr.addFlashAttribute("updateMsg", "success");
		return "redirect:/user/memberLogin";

	}
	
	@RequestMapping(value="/myPage", method=RequestMethod.GET)
	public String selectMember(String user_id) throws Exception {
		memberService.selectMember(user_id);
		return "/user/myPage";
	}


}

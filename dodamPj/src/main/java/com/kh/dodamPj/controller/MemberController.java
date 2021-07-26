package com.kh.dodamPj.controller;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.BoardService;
import com.kh.dodamPj.service.MemberService;
import com.kh.dodamPj.vo.EmailDto;
import com.kh.dodamPj.vo.MemberVo;

@Controller
@RequestMapping(value = "/user")
public class MemberController {
	@Inject
	private MemberService memberService;
	@Inject
	private BoardService boardService;
	/* NaverLoginBO */ // 이거 안씀 네이버 api
//	private NaverLoginBo naverLoginBO;
//	private String apiResult = null;
	@Inject
	private JavaMailSenderImpl mailSender;

//	@Autowired // 패스워드 security용 --21.07.16
//	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String email() throws Exception {
		return "/user/email";
	}

	@RequestMapping(value = "/changePasswordForm", method = RequestMethod.GET)
	public String changePasswordForm() throws Exception {
		return "/user/changePasswordForm";
	}

	@RequestMapping(value = "/emailSuccess", method = RequestMethod.GET)
	public String emailSuccess() throws Exception {
		return "/user/emailSuccess";
	}

	// 로그인 페이지로 이동
	@RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
	public String memberLogin() throws Exception {
		return "/user/memberLogin";
	}

	@RequestMapping(value = "/directions", method = RequestMethod.GET)
	public String directions() throws Exception {
		return "/user/directions";
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

	// 회원가입 폼으로 이동
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm() throws Exception {
		return "/user/joinForm";
	}

	// 마이페이지 21.07.14
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage(String user_id, Model model) throws Exception {
		System.out.println("user_id: " + user_id);
		MemberVo memberVo = memberService.selectMember(user_id);
		model.addAttribute("memberVo", memberVo);
		return "/user/myPage";
	}

	// 아이디 찾기 폼으로 이동
	@RequestMapping(value = "/findId", method = RequestMethod.GET)
	public String findId() throws Exception {
		return "/user/findId";
	}

	// 패스워드 찾기 폼으로 이동
	@RequestMapping(value = "/findPw", method = RequestMethod.GET)
	public String findPw() throws Exception {
		return "/user/findPw";
	}

	// 회원가입 처리
	@RequestMapping(value = "/joinRun", method = RequestMethod.POST)
	public String joinRun(MemberVo memberVo, String user_pw, RedirectAttributes rttr) throws Exception {
		System.out.println("user_pw: " + user_pw);
//		회원가입 할때 입력한 패스워드 암호화 --21.07.16
//		memberVo.setUser_pw(passwordEncoder.encode(user_pw));
		memberService.joinRun(memberVo);
		System.out.println("Join MemeberVo: " + memberVo);
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
	public String findId(String user_name, String phoneNum, Model model, RedirectAttributes rttr) throws Exception {
		String user_id = null;
		MemberVo memberVo = memberService.findId(user_name, phoneNum);
		String name = memberVo.getUser_id();
		user_id = name;
		rttr.addFlashAttribute("msg", "success");
		return user_id; //
	}

	// 패스워드 찾기 2021-07-19
	@RequestMapping("/findPwRun")
	@ResponseBody
	public MemberVo findPw(String div, String user_id, String user_name, String phoneNum, Model model) {
		MemberVo memberVo = memberService.findPw(user_id, user_name, phoneNum);
		model.addAttribute(memberVo);
		return memberVo; //
	}

	// 패스워드 수정 21-07-14
	@RequestMapping(value = "/updatePw", method = RequestMethod.POST)
	public String updatePw(MemberVo memberVo, RedirectAttributes rttr) throws Exception {
		System.out.println("updatePw MemeberVo: " + memberVo);
		String user_pw = memberVo.getUser_pw();
//		memberVo.setUser_pw(passwordEncoder.encode(user_pw));
		memberService.updatePw(memberVo);
		rttr.addFlashAttribute("updateMsg", "success");
		return "redirect:/user/memberLogin";

	}

	// 패스워드 찾기 할때 이메일 전송 21-07-21 (재수정 - 패스워드 찾을때 정보가 없으면 null 리턴)
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
	@ResponseBody
	public String sendMail(EmailDto emailDto, String user_id, String user_name, String user_email, String phoneNum,
			RedirectAttributes rttr) throws Exception {
		String pw;
		MemberVo memberVo = memberService.findPw(user_id, user_name, phoneNum);
		System.out.println("memberVo:" + memberVo);
		if (memberVo != null) {
			pw = memberVo.getUser_pw();
			System.out.println("emailDto:" + emailDto);
			// 준비 작업 - 설정
			MimeMessagePreparator preparator = new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
					helper.setFrom(emailDto.getFrom());
					helper.setTo(user_email);
					helper.setSubject("도담 임시비밀번호 안내");
					helper.setText("<html><body><label>회원님의 임시 비밀번호는 [ " + pw
							+ " ] 입니다</label><br/><a href='localhost/user/changePasswordForm'>비밀번호 변경</a></body></html>",
							true);
				}
			};

			// 보내기
			mailSender.send(preparator);
			rttr.addFlashAttribute("msg", "success");
		} else {
			pw = "";
		}
		return pw;
	}

	// 이메일 인증 21-07-21
	@RequestMapping(value = "/sendCode", method = RequestMethod.GET)
	@ResponseBody
	public int sendCode(EmailDto emailDto, String user_id, String user_name, String user_email, String phoneNum,
			RedirectAttributes rttr) throws Exception {
		//인증 코드 랜덤 생성 5자리
		Random random = new Random();
		int code = random.nextInt(99999)+11111;
		System.out.println("memberVo:" + code);
		System.out.println("emailDto:" + emailDto);
		// 준비 작업 - 설정
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
				helper.setFrom(emailDto.getFrom());
				helper.setTo(user_email);
				helper.setSubject("도담 이메일 인증 코드 안내");
				helper.setText("<html><body><label>인증코드 [ " + code + " ] 를 입력해주세요</label><br/></body></html>", true);
			}
		};
		// 보내기
		mailSender.send(preparator);
		rttr.addFlashAttribute("msg", "success");

		return code;
	}

}

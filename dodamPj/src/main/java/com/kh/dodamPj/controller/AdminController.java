package com.kh.dodamPj.controller;

import java.io.FileInputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.AdminService;
import com.kh.dodamPj.service.AdoptService;
import com.kh.dodamPj.service.AnimalService;
import com.kh.dodamPj.service.BoardService;
import com.kh.dodamPj.service.MemberService;
import com.kh.dodamPj.service.NoticeService;
import com.kh.dodamPj.service.VolunteerService;
import com.kh.dodamPj.util.AnimalFileUploadUtil;
import com.kh.dodamPj.vo.A_PagingDto;
import com.kh.dodamPj.vo.AdoptVo;
import com.kh.dodamPj.vo.AnimalVo;
import com.kh.dodamPj.vo.MemberVo;
import com.kh.dodamPj.vo.NoticeVo;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Inject
	private AdminService adminService;
	@Inject
	private BoardService boardService;
	@Inject
	private NoticeService noticeService;
	@Inject
	private MemberService memberService;
	@Inject
	private VolunteerService volunteerService;
	@Inject
	private AnimalService animalService;
	@Inject
	private AdoptService adoptService;

	
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
	
	// 로그아웃 하는거
	@RequestMapping("/logout")
	public String logout(HttpSession session,RedirectAttributes rttr) {
	   session.invalidate();
	   return "redirect:/"; // 로그아웃을 누르면 mainPage.jsp로 리다이렉트
	}
	
	// 보호중인 동물 페이지
	@RequestMapping(value="/adminProtectList", method=RequestMethod.GET)
	public String adminProtectAnimal(Model model, A_PagingDto aPagingDto) throws Exception {
		int count = adminService.getCount(aPagingDto);
		aPagingDto.setCount(count);
		List<AnimalVo> aList = animalService.animalList(aPagingDto);
		model.addAttribute("aList", aList);
		model.addAttribute("aPagingDto", aPagingDto);
		return "admin/adminProtectList";
	}
		
	// 보호중인 동물 등록 페이지
	@RequestMapping(value="/protectAnimalForm", method=RequestMethod.GET)
	public String protectAnimalForm() throws Exception {
		return "admin/protectAnimalForm";
	}
		
	// 보호중인 동물 등록 내용 전송
	@RequestMapping(value="/insertAnimalRun", method=RequestMethod.POST)
	public String insertAnimalRun(AnimalVo animalVo, MultipartFile file, RedirectAttributes rttr) throws Exception {
		String orgFileName = file.getOriginalFilename();
		String filePath = AnimalFileUploadUtil.uploadFile("E:/upload", orgFileName, file.getBytes());
		animalVo.setA_picture(filePath);
		adminService.insertAnimalRun(animalVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/admin/adminProtectList";
	}
		
	// 보호중인 동물 상세 페이지
	@RequestMapping(value="/adminProtectCont", method=RequestMethod.GET)
	public String protectAnimalContent(A_PagingDto aPagingDto, Model model, int a_no) throws Exception {
		AnimalVo animalVo = adminService.selectAnimal(a_no);
		model.addAttribute("animalVo", animalVo);
		return "admin/adminProtectCont";
	}
		
	// 보호중인 동물 수정 페이지
	@RequestMapping(value="/adminProtectModiForm", method=RequestMethod.GET)
	public String adminProtectModiForm(Model model, int a_no) throws Exception {
		AnimalVo animalVo = adminService.selectAnimal(a_no);
		model.addAttribute("animalVo", animalVo);
		return "admin/adminProtectModiForm";
	}
				
	// 보호중인 동물 수정 정보 전송
	@RequestMapping(value="/adminProtectModiRun", method=RequestMethod.POST)
	public String adminProtectModiRun(AnimalVo animalVo, RedirectAttributes rttr) throws Exception {
		adminService.modifyAnimalRun(animalVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/admin/adminProtectList";
	}
		
	// 보호중인 동물 삭제 내용 전송
	@RequestMapping(value="/adminDeleteProtectRun", method=RequestMethod.GET)
	public String adminDeleteProtectRun(int a_no) throws Exception {
		adminService.deleteAnimalRun(a_no);
		return "redirect:/admin/adminProtectList";
	}
				
	@RequestMapping(value="/displayImage", method=RequestMethod.GET)
	@ResponseBody
	public byte[] displayImage(String fileName) throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		byte[] bytes = IOUtils.toByteArray(fis);
		fis.close();
		return bytes;
	}
	
	// 입양 신청 페이지(동물 목록)
	@RequestMapping(value="/adoptList", method=RequestMethod.GET)
	public String adminAdoptList(Model model, A_PagingDto aPagingDto) throws Exception {
		int count = adminService.getCount2(aPagingDto);
		aPagingDto.setCount(count);
		List<AdoptVo> adList = adoptService.adoptList(aPagingDto);
		model.addAttribute("adList", adList);
		model.addAttribute("aPagingDto", aPagingDto);
		return "admin/adminAdoptList";
	}
	
	// 입양 동물 등록 페이지
	@RequestMapping(value="/animalInsertForm", method=RequestMethod.GET)
	public String animalInsertForm() throws Exception {
		return "admin/animalInsertForm";
	}
		
	// 입양 동물 등록 정보 전송
	@RequestMapping(value="/animalInsertRun", method=RequestMethod.POST)
	public String animalInsertRun(AdoptVo adoptVo, MultipartFile file, RedirectAttributes rttr) throws Exception {
		String orgFileName = file.getOriginalFilename();
		String filePath = AnimalFileUploadUtil.uploadFile("E:/upload", orgFileName, file.getBytes());
		adoptVo.setAd_picture(filePath);
		adminService.animalInsertRun(adoptVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/admin/adoptList";
	}
	
	// 입양 동물 상세정보 페이지
	@RequestMapping(value="/adminAnimalCont", method=RequestMethod.GET)
	public String animalCont(A_PagingDto aPagingDto, Model model, int ad_no) throws Exception {
		AdoptVo adoptVo = adminService.animalCont(ad_no);
		//System.out.println("adoptVo" + adoptVo);
		model.addAttribute("adoptVo", adoptVo);
		return "admin/adminAnimalCont";
	}
	
	// 입양 동물 수정 페이지
	@RequestMapping(value="/animalModiForm", method=RequestMethod.GET)
	public String animalModiForm(Model model, int ad_no) throws Exception {
		AdoptVo adoptVo = adminService.animalCont(ad_no);
		model.addAttribute("adoptVo", adoptVo);
		return "admin/animalModiForm";
	}
		
	// 입양 동물 수정 정보 전송
	@RequestMapping(value="/animalModifyRun", method=RequestMethod.POST)
	public String animalModifyRun(AdoptVo adoptVo, RedirectAttributes rttr) throws Exception {
		adminService.animalModifyRun(adoptVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/admin/adoptList";
	}
		
	// 입양 동물 정보 삭제
	@RequestMapping(value="/animalDeleteRun", method=RequestMethod.GET)
	public String animalDeleteRun(int ad_no, RedirectAttributes rttr) throws Exception {
		adminService.animalDeleteRun(ad_no);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/admin/adoptList";
	}

}

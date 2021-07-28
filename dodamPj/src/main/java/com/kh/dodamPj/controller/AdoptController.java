package com.kh.dodamPj.controller;

import java.io.FileInputStream;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.AdoptService;
import com.kh.dodamPj.util.AnimalFileUploadUtil;
import com.kh.dodamPj.vo.AdoptVo;
import com.kh.dodamPj.vo.ApplyUserVo;

import com.kh.dodamPj.vo.A_PagingDto;
import com.kh.dodamPj.vo.AdoptVo;
import com.kh.dodamPj.vo.ApplyUserVo;
import com.kh.dodamPj.vo.PagingDto;

@Controller
@RequestMapping(value="/adopt")
public class AdoptController {
	
	@Inject
	private AdoptService adoptService;

	// 입양 정보 페이지
	@RequestMapping(value="/adoptInfo", method=RequestMethod.GET)
	public String adoptInfo() throws Exception {
		return "adopt/adoptInfo";
	}
	
	// 입양 신청 페이지(동물 목록)
	@RequestMapping(value="/applyAdopt", method=RequestMethod.GET)
	public String applyAdopt(Model model) throws Exception {
		List<AdoptVo> adList = adoptService.adoptList();
		model.addAttribute("adList", adList);
		return "adopt/applyAdopt";
	}
	
	// 입양 동물 등록 페이지(관리자 전용)
	@RequestMapping(value="/animalInsertForm", method=RequestMethod.GET)
	public String animalInsertForm() throws Exception {
		return "adopt/animalInsertForm";
	}
	
	// 입양 동물 등록 정보 전송(관리자 전용)
	@RequestMapping(value="/animalInsertRun", method=RequestMethod.POST)
	public String animalInsertRun(AdoptVo adoptVo, MultipartFile file, RedirectAttributes rttr) throws Exception {
		String orgFileName = file.getOriginalFilename();
		String filePath = AnimalFileUploadUtil.uploadFile("E:/upload", orgFileName, file.getBytes());
		adoptVo.setAd_picture(filePath);
		adoptService.animalInsertRun(adoptVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/adopt/applyAdopt";
	}
	
	// 입양 동물 상세정보 페이지
	@RequestMapping(value="/animalCont", method=RequestMethod.GET)
	public String applyAdopt(Model model, A_PagingDto aPagingDto) throws Exception {
		int count = adoptService.getCount(aPagingDto);
		aPagingDto.setCount(count);
		List<AdoptVo> adList = adoptService.adoptList(aPagingDto);
		model.addAttribute("adList", adList);
		model.addAttribute("aPagingDto", aPagingDto);	
		return "adopt/applyAdopt";
	}
	
	// 입양 동물 상세정보 페이지
	@RequestMapping(value="/animalCont", method=RequestMethod.GET)
	public String animalCont(A_PagingDto aPagingDto, Model model, int ad_no) throws Exception {
		AdoptVo adoptVo = adoptService.animalCont(ad_no);
		//System.out.println("adoptVo" + adoptVo);
		model.addAttribute("adoptVo", adoptVo);
		return "adopt/animalCont";
	}

	
	// 입양 동물 수정 페이지
	@RequestMapping(value="/animalModiForm", method=RequestMethod.GET)
	public String animalModiForm(Model model, int ad_no) throws Exception {
		AdoptVo adoptVo = adoptService.animalCont(ad_no);
		model.addAttribute("adoptVo", adoptVo);
		return "adopt/animalModiForm";
	}
	
	// 입양 동물 수정 정보 전송
	@RequestMapping(value="/animalModifyRun", method=RequestMethod.POST)
	public String animalModifyRun(AdoptVo adoptVo, RedirectAttributes rttr) throws Exception {
		adoptService.animalModifyRun(adoptVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/adopt/applyAdopt";
	}
	
	// 입양 동물 정보 삭제
	@RequestMapping(value="/animalDeleteRun", method=RequestMethod.GET)
	public String animalDeleteRun(int ad_no, RedirectAttributes rttr) throws Exception {
		adoptService.animalDeleteRun(ad_no);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/adopt/applyAdopt";
	}
	
	// 입양 예약 목록 페이지
	@RequestMapping(value="/applyList", method=RequestMethod.GET)
	public String applyList(Model model) throws Exception {
		List<ApplyUserVo> auList = adoptService.applyList();
		model.addAttribute("auList", auList);


	// 입양 예약 목록 페이지
	@RequestMapping(value="/applyList", method=RequestMethod.GET)
	public String applyList(Model model, PagingDto pagingDto) throws Exception {
		int count = adoptService.getCountApply(pagingDto);
		pagingDto.setCount(count);
		List<ApplyUserVo> auList = adoptService.applyList(pagingDto);
		model.addAttribute("auList", auList);
		model.addAttribute("pagingDto", pagingDto);
		return "adopt/applyList";
	}
		
	// 입양 신청 폼 페이지
	@RequestMapping(value="/applyForm", method=RequestMethod.GET)
	public String applyForm(Model model, int ad_no) throws Exception {
		AdoptVo adoptVo = adoptService.animalCont(ad_no);
		//System.out.println("adoptVo" + adoptVo);
		model.addAttribute("adoptVo", adoptVo);
		return "adopt/applyForm";
	}
	

	// 입양 상담 신청서 작성시 상담 시간 중복 체크
	@RequestMapping(value="/checkDupTime", method=RequestMethod.GET)
	@ResponseBody
	public String checkDupTime(String adopt_date, String adopt_time) throws Exception {
		boolean result = adoptService.checkDupTime(adopt_date, adopt_time);
		return String.valueOf(result);
	}

	// 입양 신청 정보 전송
	@RequestMapping(value="/insertApplyRun", method=RequestMethod.POST)
	public String insertApplyRun(ApplyUserVo applyUserVo, RedirectAttributes rttr) throws Exception {
		adoptService.insertApplyRun(applyUserVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/adopt/applyAdopt";
	}
	
	// 입양 신청 상세 정보
	@RequestMapping(value="/applyContent", method=RequestMethod.GET)
	public String applyContent(int au_no,Model model) throws Exception {
		List<ApplyUserVo> auList = adoptService.applyList();
		model.addAttribute("auList", auList);
		return "adopt/applyContent";
	}
	
	public String applyContent(PagingDto pagingDto, Model model, int au_no) throws Exception {
		ApplyUserVo applyUserVo = adoptService.selectApply(au_no);
		model.addAttribute("applyUserVo", applyUserVo);
		return "adopt/applyContent";
	}
	
	// 입양 신청서 수정 정보 전송
	@RequestMapping(value="/modifyApplyRun", method=RequestMethod.POST)
	public String modifyApplyRun(ApplyUserVo applyUserVo, RedirectAttributes rttr) throws Exception {
		adoptService.modifyApplyRun(applyUserVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/adopt/applyContent?au_no=" + applyUserVo.getAu_no();
	}
	
	// 입양 신청서 삭제
	@RequestMapping(value="/deleteApplyRun", method=RequestMethod.GET)
	public String deleteApplyRun(int au_no, RedirectAttributes rttr) throws Exception {
		adoptService.deleteApplyRun(au_no);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/adopt/applyList";
	}
	
	@RequestMapping(value="/displayImage", method=RequestMethod.GET)
	@ResponseBody
	public byte[] displayImage(String fileName) throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		byte[] bytes = IOUtils.toByteArray(fis);
		fis.close();
		return bytes;
	}
	
}

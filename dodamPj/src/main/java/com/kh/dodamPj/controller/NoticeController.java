
package com.kh.dodamPj.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.NoticeService;
import com.kh.dodamPj.vo.NoticeVo;
import com.kh.dodamPj.vo.PagingDto;


@Controller
@RequestMapping(value="notice")
public class NoticeController {
	
	private static final String RE = "redirect:";
	
	@Inject
	private NoticeService noticeService;
	
	//공지사항 리스트
	//페이징 처리 완료 함
	@RequestMapping(value="/noticeList",method=RequestMethod.GET)
	public String menu1(Model model,PagingDto pagingDto) throws Exception{
		int count = noticeService.getCount(pagingDto); //페이징
		pagingDto.setCount(count); //페이징
		
//		int stp = pagingDto.getStartPage(); // startPage 확인용
//		System.out.println("pDto: "+stp); // startPage 확인용
		System.out.println("pDto: "+pagingDto);
		
		
		List<NoticeVo> list = noticeService.listAll(pagingDto);
		model.addAttribute("noticeList", list);
		model.addAttribute("pagingDto1", pagingDto);
		return "/notice/noticeList";
		
	}
	
	//공지사항 작성 폼으로 이동
	@RequestMapping(value="/noticeWriteForm",method=RequestMethod.GET)
	public String noticeWriteForm() throws Exception{
		
		return "/notice/noticeWriteForm";
		
	}
	//공지사항 수정 리스트
	@RequestMapping(value="/noticeModify",method=RequestMethod.GET)
	public String noticeModify(NoticeVo noticeVo,Model model,PagingDto pagingDto) throws Exception{
		List<NoticeVo> list = noticeService.listAll(pagingDto);
		model.addAttribute("list2", list);
		return "/notice/noticeModify";
		
	}
	//공지사항 작성 처리
		@RequestMapping(value="/noticeModifyForm",method=RequestMethod.GET)
		public String noticeModifyForm(int n_no, Model model) throws Exception{
			NoticeVo noticeVo =noticeService.content(n_no);
			System.out.println("content noticeVo: " +noticeVo);
			System.out.println(n_no);
			model.addAttribute("noticeVo", noticeVo);
			return "/notice/noticeModifyForm";
			
		}
	//공지사항 작성 처리
	@RequestMapping(value="/noticeWriteRun",method=RequestMethod.POST)
	public String noticeWriteRun(NoticeVo noticeVo, RedirectAttributes rttr,HttpSession session) throws Exception{
		System.out.println("noticeVo: "+noticeVo);
		noticeService.writeRun(noticeVo);
		rttr.addFlashAttribute("msg", "success");
		return RE+"/admin/adminPage";
		
	}
	//공지사항 수정 처리
	@RequestMapping(value="/noticeModifyRun",method=RequestMethod.POST)
	public String noticeModifyRun(NoticeVo noticeVo, RedirectAttributes rttr,HttpSession session) throws Exception{
		System.out.println("noticeVo: "+noticeVo);
		noticeService.modifyRun(noticeVo);
		rttr.addFlashAttribute("msg", "success");
		return RE+"/notice/noticeModify";
		
	}
	//공지 상세보기
	@RequestMapping(value="/content",method=RequestMethod.GET)
	public String content(int n_no, Model model) throws Exception{
		NoticeVo noticeVo =noticeService.content(n_no);
		System.out.println("content noticeVo: " +noticeVo);
		System.out.println(n_no);
		model.addAttribute("noticeVo", noticeVo);
		return "/notice/notice_content";
		
	}
	
	//공지사항 삭제
	@RequestMapping(value="/noticeDeleteRun", method=RequestMethod.GET)
	public String deleteRun(int n_no, RedirectAttributes rttr) throws Exception {
		System.out.println("b_no:" + n_no);
		noticeService.deleteRun(n_no);
		rttr.addFlashAttribute("msgDelete", "success");
		return RE+"/notice/noticeModify";
	}
	
}

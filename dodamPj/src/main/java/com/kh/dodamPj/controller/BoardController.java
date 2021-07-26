package com.kh.dodamPj.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.dodamPj.service.BoardService;
import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.PagingDto;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Inject
	private BoardService boardSerivce;
	
	@RequestMapping(value="/freeBoard", method=RequestMethod.GET)
	public String freeBoard(Model model, PagingDto pagingDto) throws Exception { // 자유게시판
		int count = boardSerivce.getCount(pagingDto);
		pagingDto.setCount(count);
		String key = pagingDto.getKeyword();
		System.out.println("key: "+ key);
		List<BoardVo> list = boardSerivce.freeBoard(pagingDto); 
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", pagingDto);
		return "board/freeBoard";
	}
	
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String writeForm() throws Exception { // 글쓰기폼
		return "board/writeForm"; 
	}
	
	@RequestMapping(value="/writeRun", method=RequestMethod.POST)
	public String writeRun(BoardVo boardVo) throws Exception { // 글쓰기폼->자유게시판
		boardSerivce.writeRun(boardVo);
		String name = boardVo.getUser_id();
		System.out.println("boardVo "+boardVo);
		System.out.println("name "+name);
		return "redirect:/board/freeBoard";
	}

	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String content(int b_no, Model model) throws Exception {
		BoardVo boardVo = boardSerivce.content(b_no);
		model.addAttribute("boardVo", boardVo);
		return "board/content";
	}
	
	@RequestMapping(value="/modifyForm", method=RequestMethod.GET)
	public String modifyForm(int b_no, Model model) throws Exception { // 수정폼
		BoardVo boardVo = boardSerivce.content(b_no);
		model.addAttribute("boardVo", boardVo);
		return "board/modifyForm"; 
	}
	
	@RequestMapping(value="/modifyRun", method=RequestMethod.POST)
	public String modifyRun(BoardVo boardVo) throws Exception { // 수정폼->자유게시판
		boardSerivce.modifyRun(boardVo);
		return "redirect:/board/freeBoard";
	}
	
	@RequestMapping(value="/deleteRun", method=RequestMethod.GET)
	public String deleteRun(int b_no) throws Exception { // 글삭제
		boardSerivce.commentDeleteRun(b_no);
		boardSerivce.deleteRun(b_no);
		return "redirect:/board/freeBoard";
	}
	
	// ckeditor 이미지 업로드
//	@ResponseBody
//	@RequestMapping(value="/imgUpload", method=RequestMethod.POST)
//	public Map<String, Object> imgUpload(@RequestParam("upload") MultipartFile img) {
//		return "";
//	}

	
}

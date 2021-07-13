package com.kh.dodam.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.dodam.service.BoardService;
import com.kh.dodam.vo.BoardVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Inject
	private BoardService boardSerivce;
	
	@RequestMapping(value="/freeBoard", method=RequestMethod.GET)
	public String freeBoard(Model model) throws Exception { // 자유게시판
		List<BoardVo> list = boardSerivce.freeBoard(); 
		model.addAttribute("list", list);
		return "board/freeBoard";
	}
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm() throws Exception { // 글쓰기폼
		return "board/writeForm"; 
	}
}

package com.kh.dodamPj.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kh.dodamPj.service.CommentService;
import com.kh.dodamPj.vo.CommentVo;
import com.kh.dodamPj.vo.MemberVo;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Inject
	private CommentService commentService;
	
	// 댓글 목록 
	@RequestMapping(value = "/getCommentList/{b_no}", method=RequestMethod.GET)
	public List<CommentVo> getCommentList(@PathVariable("b_no") int b_no, MemberVo memberVo, Model model) throws Exception {
		List<CommentVo> list = commentService.getCommentList(b_no);
		model.addAttribute("memberVo", memberVo);
		return list;
	}
	
	// 댓글 쓰기 
	@RequestMapping(value="/insertComment", method=RequestMethod.POST)
	public String insertComment(@RequestBody CommentVo commentVo,
			HttpSession session, Model model) throws Exception {
		MemberVo memberVo = (MemberVo)session.getAttribute("loginVo");
		commentVo.setUser_id(memberVo.getUser_id());
		System.out.println(commentVo);
		commentService.insertComment(commentVo);
		return "success";
	}
	
	// 댓글 삭제
	@RequestMapping(value="/deleteComment/{c_no}/{b_no}", method=RequestMethod.GET)
	public String deleteComment(@PathVariable("b_no") int b_no, @PathVariable("c_no") int c_no) throws Exception {
		commentService.deleteComment(c_no, b_no);
		return "success";
	}
	
	// 댓글 수정
}

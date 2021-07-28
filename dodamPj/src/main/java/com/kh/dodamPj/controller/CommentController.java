package com.kh.dodamPj.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.dodamPj.service.CommentService;
import com.kh.dodamPj.vo.CommentVo;
import com.kh.dodamPj.vo.MemberVo;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Inject
	private CommentService commentService;

	// 댓글 목록 (http://locahost/comment/getCommentList/500)
	@RequestMapping(value = "/getCommentList/{n_no}", method=RequestMethod.GET)
	public List<CommentVo> getCommentList(@PathVariable("n_no") int n_no) throws Exception {
		List<CommentVo> list = commentService.getCommentList(n_no);
		System.out.println("listVo: "+list );
		return list;
	}
	
	@RequestMapping(value="/insertComment", method=RequestMethod.POST)
	@ResponseBody
	public String insertComment(@RequestBody CommentVo commentVo,
			HttpSession session,Model model) throws Exception {
		MemberVo memberVo = (MemberVo)session.getAttribute("loginVo");
		commentVo.setUser_id(memberVo.getUser_id());
		System.out.println(commentVo);
		commentService.insertComment(commentVo);
		model.addAttribute("commentVo", commentVo);
		return "success";
	}
	
	@RequestMapping(value="/updateComment", method=RequestMethod.POST)
	public String updateComment(@RequestBody CommentVo commentVo) throws Exception {
		System.out.println(commentVo);
		commentService.updateComment(commentVo);
		return "success";
	}
	
	@RequestMapping(value="/deleteComment/{c_no}/{b_no}", method=RequestMethod.GET)
	public String deleteComment(@PathVariable("c_no") int c_no,
							    @PathVariable("b_no") int b_no) throws Exception {
		System.out.println("c_no:" + c_no);
		commentService.deleteComment(c_no, b_no);
		return "success";
	}
}

package com.kh.dodamPj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.dodamPj.vo.CommentVo;

@Service
public interface CommentService {
	public List<CommentVo> getCommentList(int b_no);
	public void insertComment(CommentVo commentVo);
	public void deleteComment(int c_no, int b_no);
}

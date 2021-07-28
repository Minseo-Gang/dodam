package com.kh.dodamPj.service;

import java.util.List;

import com.kh.dodamPj.vo.CommentVo;

public interface CommentService {
	public List<CommentVo> getCommentList(int n_no);
	public void insertComment(CommentVo commentVo);
	public void updateComment(CommentVo commentVo);
	public void deleteComment(int c_no, int n_no);
}

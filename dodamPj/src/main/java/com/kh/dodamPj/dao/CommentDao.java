package com.kh.dodamPj.dao;

import java.util.List;

import com.kh.dodamPj.vo.CommentVo;

public interface CommentDao {
	public List<CommentVo> getCommentList(int n_no);
	public void insertComment(CommentVo commentVo);
	public void updateComment(CommentVo commentVo);
	public void deleteComment(int c_no);
}

package com.kh.dodamPj.dao;

import com.kh.dodamPj.vo.CommentVo;

public interface CommentDao {
	// 댓글쓰기
	public void insertComment(CommentVo commentVo);
}

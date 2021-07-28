package com.kh.dodamPj.dao;

import java.util.List;

import com.kh.dodamPj.vo.CommentVo;

public interface CommentDao {
	public List<CommentVo> getCommentList(int n_no);
	public void insertComment(CommentVo commentVo);
	public void updateComment(CommentVo commentVo);
	public void deleteComment(int c_no);
	// 댓글수정
	public void updateComment(CommentVo commentVo);

	// 동물게시판 댓글목록
	public List<CommentVo> animalGetCommentList(int ab_no);

	// 동물게시판 댓글쓰기
	public void animalInsertComment(CommentVo commentVo);
}

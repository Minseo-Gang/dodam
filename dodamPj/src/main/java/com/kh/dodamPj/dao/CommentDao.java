package com.kh.dodamPj.dao;

import java.util.List;

import com.kh.dodamPj.vo.CommentVo;

public interface CommentDao {
	// 댓글목록
	public List<CommentVo> getCommentList(int b_no);
	
	// 댓글쓰기
	public void insertComment(CommentVo commentVo);
<<<<<<< Updated upstream
	// 댓글목록
	public List<CommentVo> getCommentList(int b_no);
=======
	
>>>>>>> Stashed changes
	// 댓글삭제
	public void deleteComment(int c_no);
}

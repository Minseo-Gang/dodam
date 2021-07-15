package com.kh.dodamPj.dao;

import java.util.List;

import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.PagingDto;

public interface BoardDao {
	// 글쓰기
	public void insertArticle(BoardVo boardVo);
	// 조회
	public BoardVo selectByBno(int b_no);
	// 수정
	public void updateArticle(BoardVo boardVo);
	// 삭제
	public void deleteArticle(int b_no);
	// 자유게시판
	public List<BoardVo> freeBoard();
	// 페이징
	public int getCount(PagingDto pagingDto);
	// 댓글수 변경
	public void updateCommentCnt(int b_no, int count);
<<<<<<< Updated upstream
	// 조회수 증가
	public void updateViewCnt(int b_no);
=======
>>>>>>> Stashed changes
}

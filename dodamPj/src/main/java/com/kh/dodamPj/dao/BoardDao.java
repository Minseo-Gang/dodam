package com.kh.dodamPj.dao;

import java.util.List;

import com.kh.dodamPj.vo.BoardVo;

public interface BoardDao {
	// 글쓰기
	public void insertArticle(BoardVo boardVo);
	
	// 조회
	// 수정
	// 삭제
	// 자유게시판
	public List<BoardVo> freeBoard();
}

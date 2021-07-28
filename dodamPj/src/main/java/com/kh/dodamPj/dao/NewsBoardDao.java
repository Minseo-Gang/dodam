package com.kh.dodamPj.dao;

import java.util.List;

import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.NewsBoardVo;

public interface NewsBoardDao {
	// 동물게시판목록
	public List<NewsBoardVo> newsBoard(PagingDto pagingDto);
	// 페이징
	public int getCount(PagingDto pagingDto);
	// 글쓰기
	public void insertArticle(NewsBoardVo newsBoardVo);
	// 조회
	public NewsBoardVo selectByBno(int ab_no);
	// 수정
	public void updateArticle(NewsBoardVo newsBoardVo);
	// 삭제
	public void deleteArticle(int ab_no);
	// 댓글수 변경
	public void updateCommentCnt(int ab_no, int count);
	// 조회수 증가
	public void updateViewCnt(int ab_no);
	
	// 게시글 삭제 시 댓글 삭제
	public void animalCommentDeleteArticle(int ab_no);

	
	// 첨부파일
	public void insertAttach(NewsBoardVo newsBoardVo);
	// nextval 얻기
	public int getNextVal();
	// 첨부파일관련
	public String selectFile(int ab_no);
}

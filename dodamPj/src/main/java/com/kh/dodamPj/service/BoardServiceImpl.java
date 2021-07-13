package com.kh.dodamPj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.dodamPj.dao.BoardDao;
import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.PagingDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao boardDao;

	@Override
	public List<BoardVo> freeBoard() { //자유게시판
		List<BoardVo> list = boardDao.freeBoard();
		return list;
	}

	@Override
	public void writeRun(BoardVo boardVo) { // 글쓰기
		boardDao.insertArticle(boardVo);
		String name = boardVo.getUser_id();
		System.out.println("name "+name);
	}

	@Override
	public void modifyRun(BoardVo boardVo) { // 수정하기
		boardDao.updateArticle(boardVo);
	}

	@Override
	public BoardVo content(int b_no) { // 목록
		BoardVo boardVo = boardDao.selectByBno(b_no);
		return boardVo;
	}

	@Override
	public void deleteRun(int b_no) { // 삭제하기
		boardDao.deleteArticle(b_no);
	}

	@Override
	public int getCount(PagingDto pagingDto) {
		int count = boardDao.getCount(pagingDto);
		return count;
	}


}

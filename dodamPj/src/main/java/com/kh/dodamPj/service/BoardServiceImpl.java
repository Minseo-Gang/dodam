package com.kh.dodamPj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.dodamPj.dao.BoardDao;
import com.kh.dodamPj.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao boardDao;

	@Override
	public List<BoardVo> freeBoard() { //자유게시판
		List<BoardVo> list = boardDao.freeBoard();
		return list;
	}


}

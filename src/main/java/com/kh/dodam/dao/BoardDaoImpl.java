package com.kh.dodam.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodam.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private static final String NAMESPACE = "com.kh.dodam.board.";

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertArticle(BoardVo boardVo) {
		sqlSession.insert(NAMESPACE + "insertArticle", boardVo);
	}

	@Override
	public List<BoardVo> freeBoard() {
		List<BoardVo> list = sqlSession.selectList(NAMESPACE + "freeBoard");
		return list;
	}

}

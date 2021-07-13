package com.kh.dodamPj.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.PagingDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private static final String NAMESPACE = "com.kh.dodamPj.board.";

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertArticle(BoardVo boardVo) {
		sqlSession.insert(NAMESPACE + "insertArticle", boardVo);
		String name = boardVo.getUser_id();
		System.out.println("name "+name);
	}

	@Override
	public List<BoardVo> freeBoard() {
		List<BoardVo> list = sqlSession.selectList(NAMESPACE + "freeBoard");
		return list;
	}

	@Override
	public BoardVo selectByBno(int b_no) {
		BoardVo boardVo = sqlSession.selectOne(NAMESPACE + "selectByBno", b_no);
		return boardVo;
	}
	
	@Override
	public void updateArticle(BoardVo boardVo) {
		sqlSession.update(NAMESPACE + "updateArticle", boardVo);
	}

	@Override
	public void deleteArticle(int b_no) {
		sqlSession.delete(NAMESPACE + "deleteArticle", b_no);
	}

	@Override
	public int getCount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
		return count;
	}

}

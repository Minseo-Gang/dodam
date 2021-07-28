package com.kh.dodamPj.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.dao.BoardDao;
import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.LostVo;
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
	public List<BoardVo> freeBoard(PagingDto pagingDto) {
		List<BoardVo> list = sqlSession.selectList(NAMESPACE + "freeBoard", pagingDto);
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

	@Override
	public void updateCommentCnt(int b_no, int count) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("b_no", b_no);
		map.put("count", count);
		sqlSession.update(NAMESPACE + "updateCommentCnt", map);
	}

	@Override
	public void updateViewCnt(int b_no) {
		sqlSession.update(NAMESPACE + "updateViewCnt", b_no);
	}
	
	@Override
	public void animalUpdateCommentCnt(int ab_no, int count) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("ab_no", ab_no);
		map.put("count", count);
		sqlSession.update(NAMESPACE + "animalUpdateCommentCnt", map);
	}

	@Override
	public void commentDeleteArticle(int b_no) {
		sqlSession.delete(NAMESPACE + "commentDeleteArticle", b_no);
	}

	@Override
	public void insertAttach(BoardVo boardVo) {
		String[] files = boardVo.getFiles();
		if(files != null && files.length > 0) {
			for(String file : files) {
				Map<String, Object> map = new HashMap<>();
				map.put("file_name", file);
				map.put("b_no", boardVo.getB_no());
				sqlSession.insert(NAMESPACE + "insertAttach", map);
			}
		}
		
	}

	@Override
	public int getNextVal() {
		int nextVal = sqlSession.selectOne(NAMESPACE + "getNextVal");
		return nextVal;
	}

	@Override
	public String selectFile(int b_no) {
		String file = sqlSession.selectOne(NAMESPACE + "selectFile", b_no);
		return file;
	}

	@Override
	public void updateAttach(BoardVo boardVo) {
		String[] files = boardVo.getFiles();
		if(files != null && files.length > 0) {
			for(String file : files) {
				Map<String, Object> map = new HashMap<>();
				map.put("file_name", file);
				map.put("b_no", boardVo.getB_no());
				sqlSession.insert(NAMESPACE + "updateAttach", map);
			}
		}		
	}

}
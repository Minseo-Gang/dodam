package com.kh.dodamPj.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.dao.NewsBoardDao;
import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.NewsBoardVo;

@Repository
public class NewsBoardDaoImpl implements NewsBoardDao {

	private static final String NAMESPACE = "com.kh.dodamPj.newsboard.";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<NewsBoardVo> newsBoard(PagingDto pagingDto) {
		List<NewsBoardVo> list = sqlSession.selectList(NAMESPACE + "newsBoard", pagingDto);
		return list;
	}

	@Override
	public int getCount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
		return count;
	}

	@Override
	public void insertArticle(NewsBoardVo newsBoardVo) {
		sqlSession.insert(NAMESPACE + "insertArticle", newsBoardVo);
	}

	@Override
	public NewsBoardVo selectByBno(int ab_no) {
		NewsBoardVo newsBoardVo = sqlSession.selectOne(NAMESPACE + "selectByBno", ab_no);
		return newsBoardVo;
	}

	@Override
	public void updateArticle(NewsBoardVo newsBoardVo) {
		sqlSession.update(NAMESPACE + "updateArticle", newsBoardVo);
	}

	@Override
	public void deleteArticle(int ab_no) {
		sqlSession.delete(NAMESPACE + "deleteArticle", ab_no);
	}

	@Override
	public void updateCommentCnt(int ab_no, int count) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("ab_no", ab_no);
		map.put("count", count);
		sqlSession.update(NAMESPACE + "updateCommentCnt", map);
	}

	@Override
	public void updateViewCnt(int ab_no) {
		sqlSession.update(NAMESPACE + "updateViewCnt", ab_no);
	}
	
	@Override
	public void animalCommentDeleteArticle(int ab_no) {
		sqlSession.delete(NAMESPACE + "animalCommentDeleteArticle", ab_no);
	}
	
	@Override
	public void insertAttach(NewsBoardVo newsBoardVo) {
		String[] files = newsBoardVo.getFiles();
		if(files != null && files.length > 0) {
			for(String file : files) {
				Map<String, Object> map = new HashMap<>();
				map.put("file_name", file);
				map.put("newsBoardVo", newsBoardVo.getAb_no());
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
	public String selectFile(int ab_no) {
		String file = sqlSession.selectOne(NAMESPACE + "selectFile", ab_no);
		return file;
	}

}

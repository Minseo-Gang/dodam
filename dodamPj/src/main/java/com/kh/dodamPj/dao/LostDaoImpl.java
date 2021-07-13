package com.kh.dodamPj.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.vo.LostVo;

@Repository
public class LostDaoImpl implements LostDao {

	private final String NAMESPACE = "com.kh.dodamPj.lost.";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<LostVo> reportList() {
		List<LostVo> list = sqlSession.selectList(NAMESPACE + "reportList");
		return list;
	}

	@Override
	public void insertReport(LostVo lostVo) {
		sqlSession.insert(NAMESPACE + "insertReport", lostVo);
	}

	@Override
	public void updateReport(LostVo lostVo) {
		sqlSession.update(NAMESPACE + "updateReport", lostVo);
		
	}

	@Override
	public void deleteReport(int b_no) {
		sqlSession.delete(NAMESPACE + "deleteReport", b_no);		
	}

	@Override
	public LostVo reportContent(int b_no) {
		LostVo lostVo = sqlSession.selectOne(NAMESPACE + "reportContent", b_no);
		return lostVo;
	}

	@Override
	public void updateViewcnt(int b_no) {
		sqlSession.update(NAMESPACE + "updateViewcnt", b_no);
	}

}

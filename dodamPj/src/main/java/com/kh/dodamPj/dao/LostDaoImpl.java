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

}

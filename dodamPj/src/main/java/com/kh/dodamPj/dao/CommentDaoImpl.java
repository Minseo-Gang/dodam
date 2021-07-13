package com.kh.dodamPj.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.vo.CommentVo;

@Repository
public class CommentDaoImpl implements CommentDao {

public static final String NAMESPACE = "com.kh.dodamPj.comment.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertComment(CommentVo commentVo) {
		sqlSession.insert(NAMESPACE + "insertComment", commentVo);
	}
}

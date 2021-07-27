package com.kh.dodamPj.daoImpl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.dao.CommentDao;
import com.kh.dodamPj.vo.CommentVo;

@Repository
public class CommentDaoImpl implements CommentDao {

public static final String NAMESPACE = "com.kh.dodamPj.comment.";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<CommentVo> getCommentList(int b_no) {
		List<CommentVo> list = 
				sqlSession.selectList(NAMESPACE + "getCommentList", b_no);
		return list;
	}

	@Override
	public void insertComment(CommentVo commentVo) {
		sqlSession.insert(NAMESPACE + "insertComment", commentVo);
	}

	@Override
	public void deleteComment(int c_no) {
		sqlSession.delete(NAMESPACE + "deleteComment", c_no);
	}

}

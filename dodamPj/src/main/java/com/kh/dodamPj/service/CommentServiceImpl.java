package com.kh.dodamPj.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kh.dodamPj.dao.CommentDao;
import com.kh.dodamPj.vo.CommentVo;

@Repository
public class CommentServiceImpl implements CommentService {
	
	@Inject
	private CommentDao commentDao;

	@Override
	public void insertComment(CommentVo commentVo) {
		commentDao.insertComment(commentVo);
	}

}

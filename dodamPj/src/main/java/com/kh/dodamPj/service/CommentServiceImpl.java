package com.kh.dodamPj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.dodamPj.dao.CommentDao;
import com.kh.dodamPj.vo.CommentVo;

@Service
public class CommentServiceImpl implements CommentService {
	@Inject
	private CommentDao commentDao;
	@Override
	public List<CommentVo> getCommentList(int n_no) {
		List<CommentVo> list = commentDao.getCommentList(n_no);
		return list;
	}

	@Override
	public void insertComment(CommentVo commentVo) {
		commentDao.insertComment(commentVo);
		
	}

	@Override
	public void updateComment(CommentVo commentVo) {
		commentDao.updateComment(commentVo);
		
	}

	@Override
	public void deleteComment(int c_no, int n_no) {
		commentDao.deleteComment(c_no);
		
	}

}

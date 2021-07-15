package com.kh.dodamPj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.dodamPj.dao.BoardDao;
import com.kh.dodamPj.dao.CommentDao;
import com.kh.dodamPj.vo.CommentVo;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Inject
	private CommentDao commentDao;
	
	@Inject
	private BoardDao boardDao;
<<<<<<< Updated upstream
=======
	
	@Override
	public List<CommentVo> getCommentList(int b_no) {
		List<CommentVo> list = commentDao.getCommentList(b_no);
		return list;
	}
>>>>>>> Stashed changes

	@Override
	public List<CommentVo> getCommentList(int b_no) {
		List<CommentVo> list = commentDao.getCommentList(b_no);
		return list;
	}

	@Transactional
	@Override
	public void insertComment(CommentVo commentVo) {
		commentDao.insertComment(commentVo);
<<<<<<< Updated upstream
		boardDao.updateCommentCnt(commentVo.getB_no(), 1);
	}

	@Transactional
	@Override
	public void deleteComment(int c_no, int b_no) {
		commentDao.deleteComment(c_no);
		boardDao.updateCommentCnt(b_no, -1);
=======
//		boardDao.
>>>>>>> Stashed changes
	}

	@Transactional
	@Override
	public void deleteComment(int c_no, int b_no) {
		commentDao.deleteComment(c_no);
		boardDao.updateCommentCnt(b_no, -1);
	}

	
}

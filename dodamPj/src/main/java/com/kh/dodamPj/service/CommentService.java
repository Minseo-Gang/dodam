package com.kh.dodamPj.service;

import java.util.List;

<<<<<<< Updated upstream
import org.springframework.stereotype.Service;
=======
>>>>>>> Stashed changes

import com.kh.dodamPj.vo.CommentVo;

public interface CommentService {
	public List<CommentVo> getCommentList(int b_no);
	public void insertComment(CommentVo commentVo);
	public void deleteComment(int c_no, int b_no);
}

package com.kh.dodamPj.service;

import org.springframework.stereotype.Service;

import com.kh.dodamPj.vo.CommentVo;

@Service
public interface CommentService {
	public void insertComment(CommentVo commentVo);
}

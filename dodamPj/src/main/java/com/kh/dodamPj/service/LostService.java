package com.kh.dodamPj.service;

import java.util.List;

import com.kh.dodamPj.vo.LostVo;

public interface LostService {

	public List<LostVo> reportList();
	public void reportRun(LostVo lostVo);
	public LostVo reportContent(int b_no);
	public void reportModifyRun(LostVo lostVo);
	public void reportDeleteRun(int b_no);
}

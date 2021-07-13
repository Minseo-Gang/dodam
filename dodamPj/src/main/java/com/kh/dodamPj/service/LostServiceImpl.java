package com.kh.dodamPj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.dodamPj.dao.LostDao;
import com.kh.dodamPj.vo.LostVo;

@Service
public class LostServiceImpl implements LostService {

	@Inject
	private LostDao lostDao;
	
	@Override
	public List<LostVo> reportList() {
		List<LostVo> list = lostDao.reportList();
		return list;
	}

	@Override
	public void reportRun(LostVo lostVo) {
		lostDao.insertReport(lostVo);		
	}

	@Override
	public LostVo reportContent(int b_no) {
		LostVo lostVo = lostDao.reportContent(b_no);
		lostDao.updateViewcnt(b_no);
		return lostVo;
	}

	@Override
	public void reportModifyRun(LostVo lostVo) {
		lostDao.updateReport(lostVo);
	}

	@Override
	public void reportDeleteRun(int b_no) {
		lostDao.deleteReport(b_no);		
	}

}

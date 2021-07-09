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

}

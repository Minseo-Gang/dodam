package com.kh.dodamPj.service;

import java.util.List;


import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.dodamPj.dao.VolunteerDao;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

@Service
public class VolunteerServiceImpl implements VolunteerService {

	@Inject
	private VolunteerDao volunteerDao;

	@Override
	public List<VolunteerVo> volunReservList(PagingDto pagingDto) {
		List<VolunteerVo> list = volunteerDao.volunReservList(pagingDto);
		System.out.println("service실행");
		return list;
	}

	@Override
	public void reservVolun(VolunteerVo volunteerVo) {
		volunteerDao.reservVolun(volunteerVo);
	}

	@Override
	public int getCount(PagingDto pagingDto) {
		int count = volunteerDao.getCount(pagingDto);
		return count;
	}
	

}

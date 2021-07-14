package com.kh.dodamPj.dao;

import java.util.List;

import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

public interface VolunteerDao {

	public List<VolunteerVo> volunReservList(PagingDto pagingDto);
	public void reservVolun(VolunteerVo volunteerVo);
	public int getCount(PagingDto pagingDto);

}

package com.kh.dodamPj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

@Repository
public class VolunteerDaoImpl implements VolunteerDao {

	private static final String NAMESPACE = "com.kh.dodamPj.volunteer.";
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<VolunteerVo> volunReservList(PagingDto pagingDto) {
		List<VolunteerVo> list = 
				sqlSession.selectList(NAMESPACE + "volunReservList", pagingDto);
		return list;
	}

	@Override
	public void reservVolun(VolunteerVo volunteerVo) {
		sqlSession.insert(NAMESPACE + "reservVolun", volunteerVo);
		
	}

	@Override
	public int getCount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
		return count;
	}

	@Override
	public boolean checkDateAndTime(VolunteerVo volunteerVo) {
		int count = sqlSession.selectOne(NAMESPACE + "checkDateAndTime", volunteerVo);
		System.out.println("count : " + count);
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<VolunteerVo> myReservation(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resultInsert(VolunteerVo volunteer) {
		sqlSession.update(NAMESPACE+"resultUpdate", volunteer);
		
	}



}

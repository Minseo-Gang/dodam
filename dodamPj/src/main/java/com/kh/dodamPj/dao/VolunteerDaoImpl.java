package com.kh.dodamPj.dao;

import java.util.List;

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
		System.out.println("dao실행");
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
	public void resultInsert(VolunteerVo volunteer) {
		sqlSession.update(NAMESPACE+"resultUpdate", volunteer);
		
	}


}

package com.kh.dodamPj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.vo.AdminVo;
import com.kh.dodamPj.vo.MemberVo;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

@Repository
public class AdminDaoImpl implements AdminDao {

	
	private static final String NAMESPACE = "com.project.dodam.admin.";

	@Inject
	private SqlSession sqlSession;


	@Override
	public AdminVo login(String admin_id, String admin_pw) {
		Map<String, String> map = new HashMap<>();
		
		map.put("admin_id", admin_id);
		map.put("admin_pw", admin_pw);
		
	
		AdminVo adminVo = sqlSession.selectOne(NAMESPACE + "login", map);

		return adminVo;
	}


	@Override
	public List<MemberVo> listMember() {
			List<MemberVo> memberList = sqlSession.selectList(NAMESPACE+"listMember");
		return memberList;
	}


	@Override
	public List<VolunteerVo> volunReservList(PagingDto pagingDto) {
		List<VolunteerVo> list = 
				sqlSession.selectList(NAMESPACE + "volunReservList", pagingDto);
		System.out.println("dao실행");
		return list;
	}

}

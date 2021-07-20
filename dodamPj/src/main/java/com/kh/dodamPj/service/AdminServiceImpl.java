package com.kh.dodamPj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.dodamPj.dao.AdminDao;
import com.kh.dodamPj.dao.VolunteerDao;
import com.kh.dodamPj.vo.AdminVo;
import com.kh.dodamPj.vo.MemberVo;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDao adminDao;
	
	@Inject
	private VolunteerDao volunteerDao;

	@Override
	public void joinRun(AdminVo adminVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public AdminVo login(String admin_id, String admin_pw) {
		
		AdminVo adminVo = adminDao.login(admin_id, admin_pw);
		
		return adminVo;
	}

	@Override
	public void modifyRun(AdminVo AdminVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRun(int admin_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MemberVo> listMember() {
		List<MemberVo> memberList = adminDao.listMember();
		return memberList;
	}

	@Override
	public List<VolunteerVo> volunReservList(PagingDto pagingDto) {
		List<VolunteerVo> list = volunteerDao.volunReservList(pagingDto);
		System.out.println("service실행");
		return list;
	}

}

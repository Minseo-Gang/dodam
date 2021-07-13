package com.kh.dodamPj.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.dodamPj.dao.AdminDao;
import com.kh.dodamPj.vo.AdminVo;


@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDao adminDao;

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

}

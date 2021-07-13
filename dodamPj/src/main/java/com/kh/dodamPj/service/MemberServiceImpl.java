package com.kh.dodamPj.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.dodamPj.dao.MemberDao;
import com.kh.dodamPj.vo.MemberVo;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDao memberDao;

	

	@Override
	public void joinRun(MemberVo memberVo) {
		memberDao.insertMember(memberVo);
		
	}

	@Override
	public void modifyRun(MemberVo memberVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRun(int user_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberVo login(String user_id, String user_pw) {
		MemberVo memberVo = memberDao.login(user_id, user_pw);
		return memberVo;
		
	}

	@Override
	public boolean checkDupId(String user_id) {
		
		return memberDao.checkDupId(user_id);
	}

	@Override
	public MemberVo findId(String user_name, String phoneNum) {
		MemberVo memberVo = memberDao.findId(user_name, phoneNum);
		return memberVo;
	}

	@Override
	public MemberVo findPw(String user_id, String user_name, String phoneNum) {
		MemberVo memberVo = memberDao.findPw(user_id, user_name, phoneNum);
		return memberVo;
	}

	@Override
	public void updatePw(MemberVo memberVo) {
		memberDao.updatePw(memberVo);
		
	}

	


}

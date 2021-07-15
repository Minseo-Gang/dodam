package com.kh.dodamPj.service;

import com.kh.dodamPj.vo.MemberVo;

public interface MemberService {
	//회원가입 처리
	public void joinRun(MemberVo memberVo);
	//로그인
	public MemberVo login(String user_id,String user_pw);
	//회원 정보 수정
	public void modifyRun(MemberVo memberVo);
	//회원 탈퇴
	public void deleteRun(int user_id);
	
	public boolean checkDupId(String user_id);
	
	public MemberVo findId(String user_name,String phoneNum);
	public MemberVo findPw(String user_id,String user_name,String phoneNum);
	public void updatePw(MemberVo memberVo);
	
	//마이페이지
	public MemberVo selectMember(String user_id);
}

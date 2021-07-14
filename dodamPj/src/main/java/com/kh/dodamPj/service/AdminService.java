
package com.kh.dodamPj.service;

import com.kh.dodamPj.vo.AdminVo;

public interface AdminService {

	//회원가입 처리
		public void joinRun(AdminVo adminVo);
		//로그인
		public AdminVo login(String admin_id,String admin_pw);
		//회원 정보 수정
		public void modifyRun(AdminVo AdminVo);
		//회원 탈퇴
		public void deleteRun(int admin_id);

}

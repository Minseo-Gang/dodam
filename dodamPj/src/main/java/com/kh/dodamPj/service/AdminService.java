
package com.kh.dodamPj.service;

import java.util.List;

import com.kh.dodamPj.vo.AdminVo;
import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.MemberVo;
import com.kh.dodamPj.vo.NewsBoardVo;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

public interface AdminService {

	//회원가입 처리
	public void joinRun(AdminVo adminVo);
	//로그인
	public AdminVo login(String admin_id,String admin_pw);
	//회원 정보 수정
	public void modifyRun(AdminVo AdminVo);
	//회원 탈퇴
	public void deleteRun(int admin_id);
	
	public List<MemberVo> listMember ();
	
	public List<VolunteerVo> volunReservList(PagingDto pagingDto);
	
	public void writeRun(NewsBoardVo newsBoardVo);

}

package com.kh.dodamPj.dao;

import java.util.List;

import com.kh.dodamPj.vo.AdminVo;
import com.kh.dodamPj.vo.MemberVo;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.VolunteerVo;

public interface AdminDao {
	public AdminVo login(String admin_id,String admin_pw);
	public List<MemberVo> listMember();
	public List<VolunteerVo> volunReservList(PagingDto pagingDto);
}

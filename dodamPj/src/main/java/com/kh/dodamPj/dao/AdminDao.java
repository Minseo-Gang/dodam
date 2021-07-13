package com.kh.dodamPj.dao;

import com.kh.dodamPj.vo.AdminVo;

public interface AdminDao {
	public AdminVo login(String admin_id,String admin_pw);

}

package com.kh.dodamPj.dao;

import java.util.List;

import com.kh.dodamPj.vo.AdoptVo;
import com.kh.dodamPj.vo.ApplyUserVo;

public interface AdoptDao {
	
	// 입양 동물 목록
	public List<AdoptVo> adoptList();
	// 입양 동물 등록(관리자 전용)
	public void insertPet(AdoptVo adoptVo);
	// 첨부파일
	public void insertAttach(AdoptVo adoptVo);
	// nextval 얻기
	public int getNextVal();
	// 첨부파일관련
	public String selectFile(int ad_no);
	// 입양 동물 조회
	public AdoptVo selectOnePet(int ad_no);
	// 입양 동물 정보 수정
	public void modifyPet(AdoptVo adoptVo);
	// 입양 동물 정보 삭제
	public void deletePet(int ad_no);
	// 입양 신청 등록
	public void insertApply(ApplyUserVo applyUserVo);
	// 입양 신청 목록
	public List<ApplyUserVo> applyList();
}

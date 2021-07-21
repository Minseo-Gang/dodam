package com.kh.dodamPj.service;

import java.util.List;

import com.kh.dodamPj.vo.AdoptVo;
import com.kh.dodamPj.vo.ApplyUserVo;

public interface AdoptService {

	// 입양 동물 목록
	public List<AdoptVo> adoptList();
	// 입양 동물 등록
	public void animalInsertRun(AdoptVo adoptVo);
	// 첨부파일 관련
	public String selectFile(int ad_no);
	// 입양 동물 조회
	public AdoptVo animalCont(int ad_no);
	// 입양 동물 정보 수정
	public void animalModifyRun(AdoptVo adoptVo);
	// 입양 동물 정보 삭제
	public void animalDeleteRun(int ad_no);
	// 입양 신청서 작성
	public void insertApplyRun(ApplyUserVo applyUserVo);
	// 입양 신청 목록
	public List<ApplyUserVo> applyList();

}

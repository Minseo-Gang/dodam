package com.kh.dodamPj.service;

import java.util.List;

import com.kh.dodamPj.vo.A_PagingDto;
import com.kh.dodamPj.vo.AdoptVo;
import com.kh.dodamPj.vo.ApplyUserVo;
import com.kh.dodamPj.vo.PagingDto;

public interface AdoptService {

	// 입양 동물 목록
	public List<AdoptVo> adoptList(A_PagingDto aPagingDto);
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
	public List<ApplyUserVo> applyList(PagingDto pagingDto);
	// 입양 신청 상세
	public ApplyUserVo selectApply(int au_no);
	// 입양 신청서 수정
	public void modifyApplyRun(ApplyUserVo applyUserVo);
	// 입양 신청서 삭제
	public void deleteApplyRun(int au_no);
	// 글갯수(동물목록)
	public int getCount(A_PagingDto aPagingDto);
	// 글갯수(신청서목록)
	public int getCountApply(PagingDto pagingDto);	

}

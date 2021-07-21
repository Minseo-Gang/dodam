package com.kh.dodamPj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.dodamPj.dao.AdoptDao;
import com.kh.dodamPj.vo.AdoptVo;
import com.kh.dodamPj.vo.ApplyUserVo;

@Service
public class AdoptServiceImpl implements AdoptService {

	@Inject
	private AdoptDao adoptDao;
	
	// 입양 동물 목록
	@Override
	public List<AdoptVo> adoptList() {
		List<AdoptVo> adList = adoptDao.adoptList();
		return adList;
	}

	// 입양 동물 등록 및 첨부파일
	@Transactional
	@Override
	public void animalInsertRun(AdoptVo adoptVo) {
		int nextVal = adoptDao.getNextVal();
		adoptVo.setAd_no(nextVal);
		adoptDao.insertPet(adoptVo);
		adoptDao.insertAttach(adoptVo);
	}
	
	// 첨부파일 관련
	@Override
	public String selectFile(int ad_no) {
		String file = adoptDao.selectFile(ad_no);
		return file;
	}
	
	// 입양 동물 상세 정보
	@Override
	public AdoptVo animalCont(int ad_no) {
		AdoptVo adoptVo = adoptDao.selectOnePet(ad_no);
		return adoptVo;
	}
	
	// 입양 동물 정보 수정
	@Override
	public void animalModifyRun(AdoptVo adoptVo) {
		adoptDao.modifyPet(adoptVo);		
	}

	// 입양 동물 정보 삭제
	@Override
	public void animalDeleteRun(int ad_no) {
		adoptDao.deletePet(ad_no);		
	}
	
	// 입양 예약 신청서 작성
	@Override
	public void insertApplyRun(ApplyUserVo applyUserVo) {
		adoptDao.insertApply(applyUserVo);		
	}

	// 입양 신청 목록
	@Override
	public List<ApplyUserVo> applyList() {
		List<ApplyUserVo> auList = adoptDao.applyList();
		return auList;
	}

}

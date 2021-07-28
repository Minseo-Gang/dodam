package com.kh.dodamPj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.vo.AdoptVo;
import com.kh.dodamPj.vo.ApplyUserVo;

@Repository
public class AdoptDaoImpl implements AdoptDao {

	private final String NAMESPACE = "com.kh.dodamPj.adopt.";
	
	@Inject
	private SqlSession sqlSession;

	// 입양 동물 목록
	@Override
	public List<AdoptVo> adoptList() {
		List<AdoptVo> adList = sqlSession.selectList(NAMESPACE + "adoptList");
		return adList;
	}

	// 입양 동물 추가
	@Override
	public void insertPet(AdoptVo adoptVo) {
		sqlSession.insert(NAMESPACE + "insertPet", adoptVo);
	}

	// 입양 동물 조회
	@Override
	public AdoptVo selectOnePet(int ad_no) {
		AdoptVo adoptVo = sqlSession.selectOne(NAMESPACE + "selectOnePet", ad_no);
		return adoptVo;
	}
	
	// 입양 동물 추가 시 첨부파일
	@Override
	public void insertAttach(AdoptVo adoptVo) {
		String[] files = adoptVo.getFiles();
		if(files != null && files.length > 0) {
			for(String file : files) {
				Map<String, Object> map = new HashMap<>();
				map.put("file_name", file);
				map.put("ad_no", adoptVo.getAd_no());
				sqlSession.insert(NAMESPACE + "insertAttach", map);
			}
		}
	}
	
	// 입양 동물 정보 수정
	@Override
	public void modifyPet(AdoptVo adoptVo) {
		sqlSession.update(NAMESPACE + "modifyPet", adoptVo);
	}
	
	// 입양 동물 정보 삭제
	@Override
	public void deletePet(int ad_no) {
		sqlSession.delete(NAMESPACE + "deletePet", ad_no);
	}
	
	// 첨부파일 관련
	@Override
	public int getNextVal() {
		int nextVal = sqlSession.selectOne(NAMESPACE + "getNextVal");
		return nextVal;
	}
	// 첨부파일 관련
	@Override
	public String selectFile(int ad_no) {
		String file = sqlSession.selectOne(NAMESPACE + "selectFile", ad_no);
		return file;
	}

	// 입양 신청자 입양 신청 등록
	@Override
	public void insertApply(ApplyUserVo applyUserVo) {
		sqlSession.insert(NAMESPACE + "insertApply", applyUserVo);
	}
	
	// 입양 신청 목록
	@Override
	public List<ApplyUserVo> applyList() {
		List<ApplyUserVo> auList = sqlSession.selectList(NAMESPACE + "applyList");
		return auList;
	}

}

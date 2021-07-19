package com.kh.dodamPj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.dodamPj.dao.AnimalDao;
import com.kh.dodamPj.vo.A_PagingDto;
import com.kh.dodamPj.vo.AnimalVo;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Inject
	private AnimalDao animalDao;
	
	// 보호중 동물 목록
	@Override
	public List<AnimalVo> animalList(A_PagingDto aPagingDto) {
		List<AnimalVo> aList = animalDao.animalList(aPagingDto);
		return aList;
	}
	
	// 보호중 동물 등록 내용 및 첨부파일 전송
	@Transactional
	@Override
	public void insertAnimalRun(AnimalVo animalVo) {
		int nextVal = animalDao.getNextVal();
		animalVo.setA_no(nextVal);
		animalDao.insertAnimal(animalVo);
		animalDao.insertAttach(animalVo);
	}
	
	// 보호 동물 상세 내용
	@Override
	public AnimalVo selectAnimal(int a_no) {
		AnimalVo animalVo = animalDao.selectAnimal(a_no);
		return animalVo;
	}
	
	// 보호중 동물 목록 삭제
	@Override
	public void deleteAnimalRun(int a_no) {
		animalDao.deleteAnimal(a_no);
	}
	
	// 보호중 동물 정보 수정
	@Override
	public void modifyAnimalRun(AnimalVo animalVo) {
		animalDao.modifyAnimal(animalVo);
	}
	
	// 첨부파일 관련
	@Override
	public String selectFile(int a_no) {
		String file = animalDao.selectFile(a_no);
		return file;
	}

	// 글갯수
	@Override
	public int getCount(A_PagingDto aPagingDto) {
		int count = animalDao.getCount(aPagingDto);
		return count;
	}

}

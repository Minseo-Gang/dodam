package com.kh.dodamPj.service;

import java.util.List;

import com.kh.dodamPj.vo.A_PagingDto;
import com.kh.dodamPj.vo.AnimalVo;

public interface AnimalService {

	// 보호중 동물 목록
	public List<AnimalVo> animalList(A_PagingDto aPagingDto);
	// 보호중 동물 등록 내용 전송
	public void insertAnimalRun(AnimalVo animalVo);
	// 보호 동물 상세 내용
	public AnimalVo selectAnimal(int a_no);
	// 보호 동물 목록 삭제
	public void deleteAnimalRun(int a_no);
	// 보호 동물 정보 수정
	public void modifyAnimalRun(AnimalVo animalVo);
	// 첨부파일 관련
	public String selectFile(int a_no);
	// 글갯수
	public int getCount(A_PagingDto aPagingDto);
}

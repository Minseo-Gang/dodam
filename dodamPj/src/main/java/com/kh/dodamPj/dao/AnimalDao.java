package com.kh.dodamPj.dao;

import java.util.List;

import com.kh.dodamPj.vo.AnimalVo;
import com.kh.dodamPj.vo.A_PagingDto;

public interface AnimalDao {
	
	// 보호중 동물 목록
	public List<AnimalVo> animalList(A_PagingDto aPagingDto);
	// 보호중 동물 등록하기
	public void insertAnimal(AnimalVo animalVo);
	// 첨부파일
	public void insertAttach(AnimalVo animalVo);
	// 보호중 동물 조회하기
	public AnimalVo selectAnimal(int a_no);
	// 보호중 동물 삭제하기
	public void deleteAnimal(int a_no);
	// 보호중 동물 정보 수정
	public void modifyAnimal(AnimalVo animalVo);
	// nextval 얻기
	public int getNextVal();
	// 첨부파일관련
	public String selectFile(int a_no);
	// 글갯수
	public int getCount(A_PagingDto aPagingDto);
}

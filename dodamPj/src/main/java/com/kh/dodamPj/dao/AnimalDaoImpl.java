package com.kh.dodamPj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.vo.A_PagingDto;
import com.kh.dodamPj.vo.AnimalVo;

@Repository
public class AnimalDaoImpl implements AnimalDao {
	
	private final String NAMESPACE = "com.kh.dodamPj.animal.";
	
	@Inject
	private SqlSession sqlSession;

	// 보호중 동물 리스트
	@Override
	public List<AnimalVo> animalList(A_PagingDto aPagingDto) {
		List<AnimalVo> aList = sqlSession.selectList(NAMESPACE + "animalList", aPagingDto);
		return aList;
	}
	
	// 보호중 동물 목록 추가
	@Override
	public void insertAnimal(AnimalVo animalVo) {
		sqlSession.insert(NAMESPACE + "insertAnimal", animalVo);
		
	}
	
	// 첨부파일 추가
	@Override
	public void insertAttach(AnimalVo animalVo) {
		String[] files = animalVo.getFiles();
		if(files != null && files.length > 0) {
			for(String file : files) {
				Map<String, Object> map = new HashMap<>();
				map.put("file_name", file);
				map.put("a_no", animalVo.getA_no());
				sqlSession.insert(NAMESPACE + "insertAttach", map);
			}
		}
	}
	
	// 보호 동물 조회
	@Override
	public AnimalVo selectAnimal(int a_no) {
		AnimalVo animalVo = sqlSession.selectOne(NAMESPACE + "selectAnimal", a_no);
		return animalVo;
	}
	
	// 보호중 동물 목록 삭제
	@Override
	public void deleteAnimal(int a_no) {
		sqlSession.delete(NAMESPACE + "deleteAnimal", a_no);
	}
	
	// 보호 동물 정보 수정
		@Override
		public void modifyAnimal(AnimalVo animalVo) {
			sqlSession.update(NAMESPACE + "updateAnimal", animalVo);
		}
	
	// 첨부파일 nextval
	@Override
	public int getNextVal() {
		int nextVal = sqlSession.selectOne(NAMESPACE + "getNextVal");
		return nextVal;
	}
	
	// 첨부파일 관련
	@Override
	public String selectFile(int a_no) {
		String file = sqlSession.selectOne(NAMESPACE + "selectFile", a_no);
		return file;
	}

	// 글갯수
	@Override
	public int getCount(A_PagingDto aPagingDto) {
		int count = sqlSession.selectOne(NAMESPACE + "getCount", aPagingDto);
		return count;
	}

}

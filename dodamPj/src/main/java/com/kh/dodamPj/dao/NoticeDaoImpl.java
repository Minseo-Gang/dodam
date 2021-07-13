package com.kh.dodamPj.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dodamPj.vo.NoticeVo;
import com.kh.dodamPj.vo.PagingDto;


@Repository
public class NoticeDaoImpl implements NoticeDao {

	private static final String NAMESPACE = "com.project.dodam.notice.";
	
	@Inject
	SqlSession sqlSession;
	
	//공지 사항 등록
	@Override
	public void insertArticle(NoticeVo noticeVo) {
		sqlSession.insert(NAMESPACE+"insertArticle", noticeVo);
		System.out.println("dao impl noticeVo: "+ noticeVo);
	}
	//공지 사항 상세 보기
	@Override
	public NoticeVo selectByBno(int n_no) {
		NoticeVo noticeVo = sqlSession.selectOne(NAMESPACE+"selectByBno",n_no);
		return noticeVo;
	}
	//공지 사항 수정
	@Override
	public void updateArticle(NoticeVo noticeVo) {
		sqlSession.update(NAMESPACE+"updateArticle", noticeVo);

	}
	//공지사항 삭제
	@Override
	public void deleteArticle(int n_no) {
		sqlSession.delete(NAMESPACE+"deleteArticle", n_no);

	}
	//공지사항 리스트
	@Override
	public List<NoticeVo> listAll(PagingDto pagingDto) {
		List<NoticeVo> list = sqlSession.selectList(NAMESPACE+"listAll",pagingDto);
		return list;
	}
	@Override
	public int getCount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
		int stp = pagingDto.getStartPage();
		System.out.println("daoimp: "+stp);
		return count;
	}

}
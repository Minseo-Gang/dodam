package com.kh.dodamPj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.dodamPj.dao.NoticeDao;
import com.kh.dodamPj.vo.NoticeVo;
import com.kh.dodamPj.vo.PagingDto;


@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	private NoticeDao noticeDao;
	
	@Override
	public List<NoticeVo> listAll(PagingDto pagingDto) {
			List<NoticeVo> list = noticeDao.listAll(pagingDto);
		return list;
	}

	@Override
	public void writeRun(NoticeVo noticeVo) {
		noticeDao.insertArticle(noticeVo);
		System.out.println("S impl noticeVo: "+noticeVo);

	}

	@Override
	public NoticeVo content(int n_no) {
		NoticeVo noticeVo = noticeDao.selectByBno(n_no);
		return noticeVo;
	}

	@Override
	public void modifyRun(NoticeVo noticeVo) {
		noticeDao.updateArticle(noticeVo);

	}

	@Override
	public void deleteRun(int n_no) {
		noticeDao.deleteArticle(n_no);

	}

	@Override
	public int getCount(PagingDto pagingDto) {
		int count = noticeDao.getCount(pagingDto);
		int stp = pagingDto.getStartPage();
		System.out.println("svcimp: "+stp);
		return count;
	}
}
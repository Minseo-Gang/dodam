package com.kh.dodamPj.service;

import java.util.List;

import com.kh.dodamPj.vo.NoticeVo;
import com.kh.dodamPj.vo.PagingDto;

public interface NoticeService {
	public List<NoticeVo> listAll(PagingDto pagingDto);
	public void writeRun(NoticeVo noticeVo);
	public NoticeVo content(int n_no);
	public void modifyRun(NoticeVo noticeVo);
	public void deleteRun(int n_no);
	public int getCount(PagingDto pagingDto);
}

package com.kh.dodamPj.serviceImpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.dodamPj.dao.NewsBoardDao;
import com.kh.dodamPj.service.NewsBoardService;
import com.kh.dodamPj.vo.PagingDto;
import com.kh.dodamPj.vo.BoardVo;
import com.kh.dodamPj.vo.NewsBoardVo;

@Service
public class NewsBoardServiceImpl implements NewsBoardService {
	
	@Inject
	private NewsBoardDao newsBoardDao;

	@Override
	public List<NewsBoardVo> newsBoard(PagingDto pagingDto) {
		List<NewsBoardVo> list = newsBoardDao.newsBoard(pagingDto);
		return list;
	}

	@Override
	public int getCount(PagingDto pagingDto) {
		int count = newsBoardDao.getCount(pagingDto);
		return count;
	}

	@Transactional
	@Override
	public void writeRun(NewsBoardVo newsBoardVo) {
		int nextval = newsBoardDao.getNextVal();
		newsBoardVo.setAb_no(nextval);
		newsBoardDao.insertArticle(newsBoardVo);
		newsBoardDao.insertAttach(newsBoardVo);
	}

	@Override
	public NewsBoardVo content(int ab_no) {
		NewsBoardVo newsBoardVo = newsBoardDao.selectByBno(ab_no);
		newsBoardDao.updateViewCnt(ab_no);
		return newsBoardVo;
	}

	@Override
	public void deleteRun(int ab_no) {
		newsBoardDao.deleteArticle(ab_no);
	}

	@Override
	public void modifyRun(NewsBoardVo newsBoardVo) {
		newsBoardDao.updateArticle(newsBoardVo);
	}
	
	// 첨부파일 관련
	@Override
	public String selectFile(int ab_no) {
		String file = newsBoardDao.selectFile(ab_no);
		return file;
	}

}

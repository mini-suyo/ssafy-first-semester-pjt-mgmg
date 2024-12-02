package com.ssafy.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.MateDao;
import com.ssafy.mvc.model.dto.Mate;

@Service
public class MateServiceImpl implements MateService {

	private MateDao mateDao;
	
	@Autowired
	public MateServiceImpl(MateDao mateDao) {
		this.mateDao = mateDao;
	}
	
	//userNo로 메이트 검색
	@Override
	public Mate getByUserNo(int userNo) {
		
		return mateDao.selectByUserNo(userNo);
	}
	
	// 메이트 등록
	@Override
	public boolean insertMate(Mate mate) {
		int result = mateDao.insertMate(mate);
		return result == 1;
	}
	
	// 메이트 수정
	@Override
	public boolean updateMate(Mate mate) {
		int result = mateDao.updateMate(mate);
		return result == 1;
	}

	// 메이트 삭제
	@Override
	public boolean deleteMate(int mateNo) {
		int result = mateDao.deleteMate(mateNo);
		return result == 1;
	}
}

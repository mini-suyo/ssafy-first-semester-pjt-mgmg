package com.ssafy.mvc.model.service;

import com.ssafy.mvc.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.DiaryDao;
import com.ssafy.mvc.model.dto.Diary;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {
	
	private final DiaryDao diaryDao;
	private final UserDao userDao;

	@Autowired
	public DiaryServiceImpl(DiaryDao diaryDao, UserDao userDao) {
		this.diaryDao = diaryDao;
		this.userDao = userDao;
	}

	// #1.
	// 사용처 : diaryCreate
	@Override
	public boolean diaryCreate (Diary diary) {
		int result = diaryDao.insertDiary(diary);
		return result == 1;
	}
	// #2.
	// 사용처 : diaryRead
	@Override
	public List<Diary> diaryRead(int userNo) {
		return diaryDao.selectDiary(userNo);
	}

	// #3.
	// 사용처 : diarySummary
	@Override
	public List<Diary> diarySummary(int userNo) {
		return diaryDao.selectSummary(userNo);
	}

}

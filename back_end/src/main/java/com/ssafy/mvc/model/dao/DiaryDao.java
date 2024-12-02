package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Diary;

public interface DiaryDao {

	int insertDiary(Diary diary);
	
	List<Diary> selectDiary(int userNo);

	List<Diary> selectSummary(int userNo);
	// 다이어리 삭제
	//int deleteDiary(int diaryNo);
	
}

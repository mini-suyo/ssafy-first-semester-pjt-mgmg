package com.ssafy.mvc.model.service;

import com.ssafy.mvc.model.dto.Diary;

import java.util.List;

public interface DiaryService {

	// #1.
	// 사용처 : diaryCreate
	boolean diaryCreate(Diary diary);

	// #2.
	// 사용처 : diaryRead
	List<Diary> diaryRead(int userNo);

	// #3.
	// 사용처 : diarySummary
	List<Diary> diarySummary(int userNo);


}

package com.ssafy.mvc.model.dao;

import com.ssafy.mvc.model.dto.Mate;

public interface MateDao {
	
	//userNo로 메이트 검색
	Mate selectByUserNo (int userNo);
	
	// 메이트 등록
	int insertMate (Mate mate);
	
	// 메이트 수정
	int updateMate (Mate mate);
	
	// 메이트 삭제
	int deleteMate (int mateNo);
}

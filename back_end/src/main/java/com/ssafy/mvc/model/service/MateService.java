package com.ssafy.mvc.model.service;

import com.ssafy.mvc.model.dto.Mate;

public interface MateService {
	
	//userNo로 메이트 검색
	Mate getByUserNo (int userNo);
	
	// 메이트 등록
	boolean insertMate (Mate mate);
	
	// 메이트 수정
	boolean updateMate (Mate mate);
	
	// 메이트 삭제
	boolean deleteMate (int mateNo);

}


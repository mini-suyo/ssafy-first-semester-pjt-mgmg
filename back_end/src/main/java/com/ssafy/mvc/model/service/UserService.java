package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.User;

public interface UserService {

	// #1.
	// 사용처 : userLogin, userRegist
	User getUserById(String id);

	// #2.
	// 사용처 : userRegist
	boolean userRegist(User user);

	// #3.
	// 사용처 : userUpdate
	boolean userUpdate(User user);

	// #4.
	// 사용처 : userUpdate
	User getUserByUserNo(int userNo);

	//유저 전체 검색
	List<User> getAllUsers();

	// #6. 유저 id로 검색
	List<User> searchUser(String id);

	// #7.
	// 사용처 : toggleMate
	void toggle(int userNo);


}

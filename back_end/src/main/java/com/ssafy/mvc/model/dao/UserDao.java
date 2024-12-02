package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.User;

public interface UserDao {

	User selectUserById(String id);

	int insertUser(User user);

	int updateUser(User user);

	User selectUserByUserNo(int userNo);

	List<User> selectAll();

	List<User> selectUserList(String id);

	void flagToggle(int userNo);

}

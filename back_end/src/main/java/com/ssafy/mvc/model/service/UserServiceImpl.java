package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	
	public UserServiceImpl (UserDao userDao) {
		this.userDao = userDao;
	}

	// #1.
	// 사용처 : userLogin, userRegist
	@Override
	public User getUserById(String id) {
		return userDao.selectUserById(id);
	}
	// #2.
	// 사용처 : userRegist
	@Override
	public boolean userRegist(User user) {
		return userDao.insertUser(user) == 1;
	}
	// #3.
	// 사용처 : userUpdate
	@Override
	public boolean userUpdate(User user) {
		return userDao.updateUser(user) == 1;
	}
	// #4.
	// 사용처 : userUpdate
	@Override
	public User getUserByUserNo(int userNo) {
		return userDao.selectUserByUserNo(userNo);
	}


	@Override
	public List<User> getAllUsers() {
		List<User> result = userDao.selectAll();
		return result;
	}

	@Override
	public List<User> searchUser(String id) {
		return userDao.selectUserList(id);
	}

	@Override
	public void toggle(int userNo) {
		userDao.flagToggle(userNo);
	}

}

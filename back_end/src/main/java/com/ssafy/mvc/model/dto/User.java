package com.ssafy.mvc.model.dto;

public class User {
	private int userNo;
	private String id;
	private String password;
	private String userName;
	private boolean mateFlag;

	public User() {
	}

	public User(int userNo, String id, String password, String userName, boolean mateFlag) {
		this.userNo = userNo;
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.mateFlag = mateFlag;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isMateFlag() {
		return mateFlag;
	}

	public void setMateFlag(boolean mateFlag) {
		this.mateFlag = mateFlag;
	}

	@Override
	public String toString() {
		return "User{" +
				"userNo=" + userNo +
				", id='" + id +
				", password=" + password +
				", userName=" + userName +
				", mateFlag=" + mateFlag +
				'}';
	}
}

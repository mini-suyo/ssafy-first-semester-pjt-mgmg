package com.ssafy.mvc.model.dto;

public class Friend {
	
	int userNo;
	int friendNo;
	String friendName;

	public Friend() {
	}

	public Friend(int userNo, int friendNo, String friendName) {
		this.userNo = userNo;
		this.friendNo = friendNo;
		this.friendName = friendName;
	}

	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getFriendNo() {
		return friendNo;
	}
	public void setFriendNo(int friendNo) {
		this.friendNo = friendNo;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	@Override
	public String toString() {
		return "Friend{" +
				"userNo=" + userNo +
				", friendNo=" + friendNo +
				", friendName=" + friendName +
				'}';
	}
}

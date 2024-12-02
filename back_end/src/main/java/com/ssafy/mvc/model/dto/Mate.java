package com.ssafy.mvc.model.dto;

public class Mate {
	private int userNo;
	private String mateName;
	private String personality;
	private int diaryCount;


	public Mate() {
	}

	public Mate(int userNo, String mateName, String personality) {
		this.userNo = userNo;
		this.mateName = mateName;
		this.personality = personality;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getMateName() {
		return mateName;
	}

	public void setMateName(String mateName) {
		this.mateName = mateName;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public int getDiaryCount() {
		return diaryCount;
	}

	public void setDiaryCount(int diary) {
		this.diaryCount = diaryCount;
	}

	@Override
	public String toString() {
		return "Mate{" +
				"userNo=" + userNo +
				", mateName=" + mateName +
				", personality=" + personality +
				", diaryCount=" + diaryCount +
				'}';
	}
}

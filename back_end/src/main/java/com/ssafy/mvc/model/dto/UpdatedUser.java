package com.ssafy.mvc.model.dto;

public class UpdatedUser {
    private int userNo;
    private String password;
    private String newPassword;

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "UpdatedUser{" +
                "userNo=" + userNo +
                ", password=" + password  +
                ", newPassword=" + newPassword +
                '}';
    }
}

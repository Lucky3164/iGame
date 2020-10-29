package com.igame.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;

    private String phoneNumber;

    private String userName;

    private String password;

    private Integer roleId;

    private String hImgPath;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String gethImgPath() {
        return hImgPath;
    }

    public void sethImgPath(String hImgPath) {
        this.hImgPath = hImgPath == null ? null : hImgPath.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", hImgPath='" + hImgPath + '\'' +
                '}';
    }
}
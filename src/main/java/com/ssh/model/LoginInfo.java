package com.ssh.model;

import java.io.Serializable;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

public class LoginInfo implements Serializable {

    public static String USER_SESSION_KEY = "loginSessionKey";
    private static final long serialVersionUID = 1L;
    private String userId;
    private String username;
    private String phone;
    private String email;
    private String idNumber;
    private Date lastLoginTime;
    private String lastLoginIp;
    private String lastLoginMac;

    public LoginInfo() {
        super();
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getIdNumber() {
        return idNumber;
    }


    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }


    public Date getLastLoginTime() {
        return lastLoginTime;
    }


    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }


    public String getLastLoginIp() {
        return lastLoginIp;
    }


    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }


    public String getLastLoginMac() {
        return lastLoginMac;
    }


    public void setLastLoginMac(String lastLoginMac) {
        this.lastLoginMac = lastLoginMac;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public static LoginInfo getLoginInfo(HttpServletRequest request) {
        return (LoginInfo) request.getSession().getAttribute(USER_SESSION_KEY);
    }


    @Override
    public String toString() {
        return "LoginInfo [userId=" + userId + ", username=" + username
                + ", phone=" + phone + ", email=" + email + ", idNumber="
                + idNumber + ", lastLoginTime=" + lastLoginTime
                + ", lastLoginIp=" + lastLoginIp + ", lastLoginMac="
                + lastLoginMac + "]";
    }

}
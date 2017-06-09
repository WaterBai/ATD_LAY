package com.ssh.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
@DynamicUpdate(true)
public class User {

    @Id
    @GeneratedValue(generator = "paymentableGenerator")    
    @GenericGenerator(name = "paymentableGenerator", strategy = "assigned")   
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_NAME")
    private String username;
    
    @Column(name = "USER_PASSWORD")
    private String password;
    
    @Column(name = "USER_SEX")
    private String sex;
    
    @Column(name = "USER_BIRTHDAY")
    private Long birthday;
    
    @Column(name = "USER_ADDRESS")
    private String address;
    
    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_PHONE")
    private String phone;
    
    @Column(name = "USER_STATUS")
    private String status;
    
    @Column(name = "USER_IDNUMBER")
    private String idNumber;

    @Column(name = "LOGIN_IP")
    private String loginIp;
    
    @Column(name = "REMARK")
    private String remark;
    
    @Column(name = "CREATE_TIME")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime = new Date();
    //private Long createTime = System.currentTimeMillis();
    
    @Column(name = "CREATE_USER")
    private String createUser;
    
    @Column(name = "UPDATE_TIME")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateTime = new Date();
    //private Long createTime = System.currentTimeMillis();
    
    @Column(name = "UPDATE_USER")
    private String updateUser;
    
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username
                + ", password=" + password + ", sex=" + sex + ", birthday="
                + birthday + ", address=" + address + ", email=" + email
                + ", phone=" + phone + ", status=" + status + ", idnumber="
                + idNumber + ", loginIp=" + loginIp + ", remark=" + remark
                + ", createTime=" + createTime + ", createUser=" + createUser
                + ", updateTime=" + updateTime + ", updateUser=" + updateUser
                + "]";
    }

}
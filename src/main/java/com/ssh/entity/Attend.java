package com.ssh.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "attend")
@DynamicUpdate(true)
public class Attend {

    @Id
    @GeneratedValue
    @Column(name = "ATD_ID")
    private Long id;
    
    @Column(name = "ATD_USERNAME")
    private String username;
    
    @Column(name = "ATD_TYPE")
    private String type;
    
    @Column(name = "ATD_PROJECT")
    private String project;
    
    @Column(name = "ATD_WORK")
    private String work;
    
    @Column(name = "START_TIME")
    private String startTime;
    
    @Column(name = "END_TIME")
    private String endTime;
    
    @Column(name = "REMARK")
    private String remark;

    @Column(name = "CREATE_TIME")
    //@DateTimeFormat(pattern="yyyy-MM-dd")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Attend [id=" + id + ", username=" + username + ", type=" + type
                + ", project=" + project + ", work=" + work + ", startTime="
                + startTime + ", endTime=" + endTime + ", remark=" + remark
                + ", createTime=" + createTime + ", createUser=" + createUser
                + ", updateTime=" + updateTime + ", updateUser=" + updateUser
                + "]";
    }

    
}
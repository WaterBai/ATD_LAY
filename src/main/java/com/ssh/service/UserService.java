package com.ssh.service;

import java.util.Map;

import com.ssh.entity.User;
import com.ssh.model.LoginInfo;
import com.ssh.model.PageBean;

public interface UserService {

    public PageBean<User> getUserPage(Map<String, String> param);
    
    //public PageBean<Map<String, Object>> getAttendPageMap(Map<String, String> param);

    public boolean addUser(User user);
    
    public boolean updateUser(User user);
    
    public boolean deleteUser(User user);
    
    public boolean checkUser(User user);
    
    public LoginInfo loginUser(String userId,String password);
    
}

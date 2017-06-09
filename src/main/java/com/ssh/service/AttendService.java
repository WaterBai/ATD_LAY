package com.ssh.service;

import java.util.Map;

import com.ssh.entity.Attend;
import com.ssh.model.PageBean;

public interface AttendService {

    public PageBean<Attend> getAttendPage(Map<String, String> param);
    
    public PageBean<Map<String, Object>> getAttendPageMap(Map<String, String> param);
    
    public Attend getAttend(String id);

    public boolean addAttend(Attend atd,String username);
    
    public boolean editAttend(Attend atd,String username);

    public int removeAttend( Map<String, Object> param, String username);
}

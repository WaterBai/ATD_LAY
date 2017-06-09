package com.ssh.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.entity.Attend;
import com.ssh.model.PageBean;
import com.ssh.repository.BaseRepository;
import com.ssh.service.AttendService;

@Service
@Transactional
public class AttendServiceImpl implements AttendService {
    @Autowired
    private BaseRepository baseDao;

    @Override
    public PageBean<Attend> getAttendPage(Map<String, String> param) {
        int currentPage = Integer.parseInt(param.get("currentPage"));
        int pageSize = Integer.parseInt(param.get("pageSize"));
        return baseDao.queryPageBeanBySqlId("atd.getAttend", param, currentPage,
                pageSize, Attend.class);
    }

    @Override
    public PageBean<Map<String, Object>> getAttendPageMap(
            Map<String, String> param) {
        int currentPage = Integer.parseInt(param.get("currentPage"));
        int pageSize = Integer.parseInt(param.get("pageSize"));
        return baseDao.queryPageBeanBySqlId("atd.getAttend", param, currentPage,
                pageSize);
    }
    
    @Override
    public Attend getAttend(String id) {
        Long atdid = Long.parseLong(id);
        Attend atd = baseDao.getById(Attend.class, atdid);
        return atd;
    }


    @Override
    public boolean addAttend(Attend atd,String username) {
        //atd.setUsername(username);
        atd.setCreateUser(username);
        atd.setUpdateUser(username);
        atd.setCreateTime(new Date());
        return baseDao.addEntity(atd);
    }

    @Override
    public boolean editAttend(Attend atd, String username) {
        atd.setUpdateUser(username);
        return baseDao.updateEntity(atd);
    }

    @Override
    public int removeAttend( Map<String, Object> param, String username) {
        //int atdid = Integer.parseInt(id);
        return baseDao.excuteBySqlId("atd.removeAttend", param);
    }
    

}

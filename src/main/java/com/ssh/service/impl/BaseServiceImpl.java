package com.ssh.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.model.PageBean;
import com.ssh.repository.BaseRepository;
import com.ssh.service.BaseService;
import com.ssh.service.TestService;

@Service
@Transactional
public class BaseServiceImpl implements BaseService{
    @Autowired
    private BaseRepository baseDao;

    @Override
    public <T> boolean addEntity(T entity) {
        return baseDao.addEntity(entity);
    }

    @Override
    public <T> boolean updateEntity(T entity){
        return baseDao.updateEntity(entity);
    }

    @Override
    public <T> boolean removeEntity(T entity) {
        return baseDao.removeEntity(entity);
    }
    
    @Override
    public <T> T getById(Class<T> clazz, Serializable id){
        return baseDao.getById(clazz, id);
    }

}

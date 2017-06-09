package com.ssh.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ssh.model.PageBean;

public interface BaseService {
    
    /** 
     * 增加一个entity对象，返回是否添加成功 
     * @param T 对象类型 
     * @param entity 实体类 
     * @return boolean true/false 
     * @throws Exception 
     * */  
    public <T> boolean addEntity(T entity);  

   
    /**  
     * 修改实体的数据，返回boolean结果 
     * @param entity 
     * @return boolean 
     * @throws Exception 
     * */  
    public <T> boolean updateEntity(T entity);  
   
    /**  
     * 传入要删除的实体，返回boolean结果 
     * @param entity 
     * @return boolean 
     * @throws Exception 
     * */  
    public <T> boolean removeEntity(T entity);
  
    /**  
     * 传入要实体类的class和Serializable主键，返回具体实体 
     * @param clazz 
     * @param id 
     * @return T 
     * @throws Exception 
     * */  
    public <T> T getById(Class<T> clazz,Serializable id);  

}

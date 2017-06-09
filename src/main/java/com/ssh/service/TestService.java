package com.ssh.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ssh.model.PageBean;

public interface TestService {
    
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
    /*public <T> T getById(Class<T> clazz,int id) throws Exception;  */
    
    /**  
     * 传入要实体类的class和Serializable主键，返回具体实体 
     * @param clazz 
     * @param id 
     * @return T 
     * @throws Exception 
     * */  
    public <T> T getById(Class<T> clazz,Serializable id);  

    /** 
     * 执行sql语句，实行增，删，改 
     * @author ending 
     * @param sql 
     * @return Integer 
     * @throws Exception 
     * */  
    public int excuteBySql(String sql,Map<String,String> param);  
    
    /**
     * 执行sql查询语句，获取list集合 
     * @param sql
     * @param param
     * @return
     */
    public List<Map<String,Object>> queryBySql(String sql,Map<String,String> param); 
    public <T> List<T> queryBySql(String sql,Map<String,String> param,Class<T> clazz);
    public List<Map<String,Object>> queryBySqlId(String sqlId,Map<String,String> param); 
    public <T> List<T> queryBySqlId(String sqlId,Map<String,String> param,Class<T> clazz);

    /**
     * 执行sql查询分页
     * @param queryId
     * @param param
     * @param currentPage
     * @param pageSize
     * @return
     */
    public <T> PageBean<T> queryPageBySql(String sql, Map<String,String> param, int currentPage, int pageSize,Class<T> clazz);
    public PageBean<Map<String, Object>> queryPageBySql(String sql, Map<String,String> param, int currentPage, int pageSize);

}

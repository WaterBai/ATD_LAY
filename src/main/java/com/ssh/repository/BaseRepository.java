package com.ssh.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ssh.model.PageBean;

public interface BaseRepository{
    
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
     * 保存或修改实体的数据，返回boolean结果 
     * @param entity 
     * @return boolean 
     * @throws Exception 
     * */  
    public <T> boolean saveOrUpdateEntity(T entity);  
   
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
    
    /**  
     * 传入要实体类的class和Serializable主键，返回具体实体 
     * @param clazz 
     * @param id 
     * @return T 
     * @throws Exception 
     * */  
    public <T> T loadById(Class<T> clazz,Serializable id);  

    /** 
     * 执行sql语句，实行增，删，改 
     * @author ending 
     * @param sql 
     * @return Integer 
     * @throws Exception 
     * */  
    //public int excuteBySql(String sql);  
    public int excuteBySqlId(String sqlId,Map<String, ?> values);  
    
    
    /**  
     * 执行sql查询语句，获取list集合 
     * @param sql 
     * @return List 
     * @throws Exception 
     * */  
    //public List<Map<String,Object>> queryBySql(String sql); 
    public List<Map<String,Object>> queryBySqlId(String sqlId,Map<String, ?> values);  
    //public <T> List<T> queryBySql(String sql,Class<T> clazz);
    public <T> List<T> queryBySqlId(String sqlId,Map<String, ?> values,Class<T> clazz);
    /**  
     * 执行sql查询分页，返回分页集合
     * @param sql 
     * @return List 
     * @throws Exception 
     * */  
    //public <T> List<T> queryPageBySql(String sql, int currentPage, int pageSize, Class<T> clazz);
    public <T> List<T> queryPageBySqlId(String sqlId,Map<String, ?> values, int currentPage, int pageSize, Class<T> clazz);
    //public List<Map<String, Object>> queryPageBySql(String sql, int currentPage, int pageSize);
    public List<Map<String, Object>> queryPageBySqlId(String sqlId,Map<String, ?> values, int currentPage, int pageSize);
    //public <T> PageBean<T> queryPageBeanBySql(String sql, int currentPage, int pageSize, Class<T> clazz);
    public <T> PageBean<T> queryPageBeanBySqlId(String sqlId,Map<String, ?> values, int currentPage, int pageSize, Class<T> clazz);
    //public PageBean<Map<String, Object>> queryPageBeanBySql(String sql, int currentPage, int pageSize);
    public PageBean<Map<String, Object>> queryPageBeanBySqlId(String sqlId,Map<String, ?> values, int currentPage, int pageSize);

}

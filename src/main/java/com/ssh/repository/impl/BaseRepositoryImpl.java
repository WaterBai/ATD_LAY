package com.ssh.repository.impl;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.db.DirectiveHandler;
import com.ssh.db.SqlType;
import com.ssh.db.StatementTemplate;
import com.ssh.db.resolver.DynamicHibernateStatementBuilder;
import com.ssh.model.PageBean;
import com.ssh.model.PageSql;
import com.ssh.repository.BaseRepository;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Repository
public class BaseRepositoryImpl implements BaseRepository, InitializingBean {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(BaseRepositoryImpl.class);
    /**
     * 模板缓存
     */
    protected Map<String, StatementTemplate> templateCache;

    @Autowired
    protected DynamicHibernateStatementBuilder dynamicStatementBuilder;

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public <T> boolean addEntity(T entity) {
        boolean bool = false;
        try {
            Serializable ser = (Serializable) this.getCurrentSession().save(
                    entity);
            if (ser != null) {
                bool = true;
            }
        } catch (Exception e) {
            bool = false;
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public <T> boolean updateEntity(T entity) {
        try {
            this.getCurrentSession().update(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public <T> boolean saveOrUpdateEntity(T entity) {
        try {
            this.getCurrentSession().saveOrUpdate(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public <T> boolean removeEntity(T entity) {
        try {
            this.getCurrentSession().delete(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getById(Class<T> clazz, Serializable id) {
        T t = null;
        if(id ==null){
            LOGGER.info("ID为空，返回空");
            return t;
        }
        try {
            t = (T) this.getCurrentSession().get(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T loadById(Class<T> clazz, Serializable id) {
        T t = null;
        try {
            t = (T) this.getCurrentSession().load(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    private int excuteBySql(String sql) {
        int result = -1;
        try {
            SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
            result = query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int excuteBySqlId(String scriptId, Map<String, ?> parameters) {
        StatementTemplate statementTemplate = templateCache.get(scriptId);
        String statement = processTemplate(statementTemplate, parameters);
        if (SqlType.SQL.equals(statementTemplate.getType())) {
            return this.excuteBySql(statement);
        } else {
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> queryBySql(String sql, Class<T> clazz) {
        try {
            Query query = this.getCurrentSession().createSQLQuery(sql)
                    .addEntity(clazz);
            List<T> list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> queryBySql(String sql) {
        try {
            Query query = this.getCurrentSession().createSQLQuery(sql)
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            List<Map<String, Object>> list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private <T> PageBean<T> queryPageBeanBySql(String sql, int currentPage,
            int pageSize, Class<T> clazz) {
        PageSql pagesql = new PageSql(sql, currentPage, pageSize);
        long l = System.currentTimeMillis();
        List<T> results = null;
        String countSql = pagesql.getCountSql();
        Query query = this.getCurrentSession().createSQLQuery(countSql);
        List<BigInteger> list = query.list();
        int totalCount = list.get(0).intValue();
        LOGGER.info((new StringBuilder()).append("查询时间:")
                .append(System.currentTimeMillis() - l).append("ms").toString());
        l = System.currentTimeMillis();
        if (totalCount > 0) {
            String limitSql = pagesql.getLimitSql(totalCount);
            results = this.queryBySql(limitSql, clazz);
        } else {
            LOGGER.info("Result is null!");
        }
        LOGGER.info((new StringBuilder()).append("查询时间:")
                .append(System.currentTimeMillis() - l).append("ms").toString());
        PageBean<T> page = new PageBean<T>(currentPage, pageSize, totalCount,
                results);
        return page;
    }

    @SuppressWarnings("unchecked")
    private PageBean<Map<String, Object>> queryPageBeanBySql(String sql,
            int currentPage, int pageSize) {
        // 封装查询sql的类，以便获取相应的sql
        PageSql pagesql = new PageSql(sql, currentPage, pageSize);
        long l = System.currentTimeMillis();
        List<Map<String, Object>> results = null;
        String countSql = pagesql.getCountSql();
        Query query = this.getCurrentSession().createSQLQuery(countSql);
        List<BigInteger> list = query.list();
        int totalCount = list.get(0).intValue();
        LOGGER.info((new StringBuilder()).append("查询时间:")
                .append(System.currentTimeMillis() - l).append("ms").toString());
        l = System.currentTimeMillis();
        String limitSql = pagesql.getLimitSql(totalCount);
        if (pagesql.getTotalCount() > 0) {
            results = this.queryBySql(limitSql);
        } else {
            LOGGER.info("Result is null!");
        }
        LOGGER.info((new StringBuilder()).append("查询时间:")
                .append(System.currentTimeMillis() - l).append("ms").toString());
        PageBean<Map<String, Object>> page = new PageBean<Map<String, Object>>(
                currentPage, pageSize, totalCount, results);
        return page;
    }

    @Override
    public List<Map<String, Object>> queryBySqlId(String scriptId,
            Map<String, ?> parameters) {
        StatementTemplate statementTemplate = templateCache.get(scriptId);
        String statement = processTemplate(statementTemplate, parameters);
        if (SqlType.SQL.equals(statementTemplate.getType())) {
            return this.queryBySql(statement);
        } else {
            return null;
        }
    }

    @Override
    public <T> List<T> queryBySqlId(String scriptId, Map<String, ?> parameters,
            Class<T> clazz) {
        StatementTemplate statementTemplate = templateCache.get(scriptId);
        String statement = processTemplate(statementTemplate, parameters);
        if (SqlType.SQL.equals(statementTemplate.getType())) {
            return this.queryBySql(statement, clazz);
        } else {
            return null;
        }
    }

    @Override
    public <T> PageBean<T> queryPageBeanBySqlId(String scriptId,
            Map<String, ?> parameters, int currentPage, int pageSize,
            Class<T> clazz) {
        StatementTemplate statementTemplate = templateCache.get(scriptId);
        String statement = processTemplate(statementTemplate, parameters);
        if (SqlType.SQL.equals(statementTemplate.getType())) {
            return this.queryPageBeanBySql(statement, currentPage, pageSize,
                    clazz);
        } else {
            return null;
        }
    }

    @Override
    public PageBean<Map<String, Object>> queryPageBeanBySqlId(String scriptId,
            Map<String, ?> parameters, int currentPage, int pageSize) {
        StatementTemplate statementTemplate = templateCache.get(scriptId);
        String statement = processTemplate(statementTemplate, parameters);
        if (SqlType.SQL.equals(statementTemplate.getType())) {
            return this.queryPageBeanBySql(statement, currentPage, pageSize);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> queryPageBySql(String sql, int currentPage,
            int pageSize, Class<T> clazz) {
        PageSql pagesql = new PageSql(sql, currentPage, pageSize);
        long l = System.currentTimeMillis();
        List<T> results = null;
        String countSql = pagesql.getCountSql();
        Query query = this.getCurrentSession().createSQLQuery(countSql);
        List<BigInteger> list = query.list();
        int totalCount = list.get(0).intValue();
        LOGGER.info((new StringBuilder()).append("查询时间:")
                .append(System.currentTimeMillis() - l).append("ms").toString());
        l = System.currentTimeMillis();
        if (totalCount > 0) {
            String limitSql = pagesql.getLimitSql();
            results = this.queryBySql(limitSql, clazz);
        } else {
            LOGGER.info("Result is null!");
        }
        LOGGER.info((new StringBuilder()).append("查询时间:")
                .append(System.currentTimeMillis() - l).append("ms").toString());
        return results;
    }

    @Override
    public <T> List<T> queryPageBySqlId(String sqlId, Map<String, ?> values,
            int currentPage, int pageSize, Class<T> clazz) {
        StatementTemplate statementTemplate = templateCache.get(sqlId);
        String statement = processTemplate(statementTemplate, values);
        if (SqlType.SQL.equals(statementTemplate.getType())) {
            return this.queryPageBySql(statement, currentPage, pageSize, clazz);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> queryPageBySql(String sql,
            int currentPage, int pageSize) {
        // 封装查询sql的类，以便获取相应的sql
        PageSql pagesql = new PageSql(sql, currentPage, pageSize);
        long l = System.currentTimeMillis();
        List<Map<String, Object>> results = null;
        String countSql = pagesql.getCountSql();
        Query query = this.getCurrentSession().createSQLQuery(countSql);

        List<BigInteger> list = query.list();
        int totalCount = list.get(0).intValue();
        LOGGER.info((new StringBuilder()).append("查询时间:")
                .append(System.currentTimeMillis() - l).append("ms").toString());
        l = System.currentTimeMillis();
        String limitSql = pagesql.getLimitSql(totalCount);
        if (pagesql.getTotalCount() > 0) {
            results = this.queryBySql(limitSql);
        } else {
            LOGGER.info("Result is null!");
        }
        LOGGER.info((new StringBuilder()).append("查询时间:")
                .append(System.currentTimeMillis() - l).append("ms").toString());
        return results;
    }

    @Override
    public List<Map<String, Object>> queryPageBySqlId(String sqlId,
            Map<String, ?> values, int currentPage, int pageSize) {
        StatementTemplate statementTemplate = templateCache.get(sqlId);
        String statement = processTemplate(statementTemplate, values);
        if (SqlType.SQL.equals(statementTemplate.getType())) {
            return this.queryPageBySql(statement, currentPage, pageSize);
        } else {
            return null;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        templateCache = new HashMap<String, StatementTemplate>();
        if (this.dynamicStatementBuilder == null) {
            throw new RuntimeException("dynamicStatementBuilder is null !!");
        }
        dynamicStatementBuilder.init();
        Map<String, String> namedHQLQueries = dynamicStatementBuilder
                .getNamedHQLQueries();
        Map<String, String> namedSQLQueries = dynamicStatementBuilder
                .getNamedSQLQueries();
        Configuration configuration = new Configuration();
        configuration.setNumberFormat("#");
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        for (Entry<String, String> entry : namedHQLQueries.entrySet()) {
            stringLoader.putTemplate(entry.getKey(), entry.getValue());
            templateCache.put(entry.getKey(), new StatementTemplate(
                    SqlType.HQL, new Template(entry.getKey(), new StringReader(
                            entry.getValue()), configuration)));
        }
        for (Entry<String, String> entry : namedSQLQueries.entrySet()) {
            stringLoader.putTemplate(entry.getKey(), entry.getValue());
            templateCache.put(entry.getKey(), new StatementTemplate(
                    SqlType.SQL, new Template(entry.getKey(), new StringReader(
                            entry.getValue()), configuration)));
        }
        configuration.setTemplateLoader(stringLoader);
    }

    protected String processTemplate(StatementTemplate statementTemplate,
            Map<String, ?> parameters) {
        Map<String, DirectiveHandler> root = new HashMap<String, DirectiveHandler>();
        if (parameters != null) {
            String key; Object obj;
            Iterator<String> it = parameters.keySet().iterator();
            while (it.hasNext()) {
                key = (String) it.next();
                obj = parameters.get(key);
                root.put(key, new DirectiveHandler(obj));
            }
        }
        StringWriter stringWriter = new StringWriter();
        try {
            Template template = statementTemplate.getTemplate();
            template.process(root, stringWriter);
        } catch (Exception e) {
            LOGGER.error("处理DAO查询参数模板时发生错误：{}", e.toString());
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

}

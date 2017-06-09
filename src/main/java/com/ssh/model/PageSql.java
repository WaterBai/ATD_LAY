package com.ssh.model;

import com.ssh.db.DBType;

public class PageSql {
    private DBType dbType;
    private String sourceSql;
    private String countSql;
    private String limitSql;
    private int totalCount;
    private int currentPage;
    private int pageSize;
    private int min;
    private int max;

    public PageSql() {

    }
    
    public PageSql(String sourceSql, int currentPage, int pageSize) {
        this.sourceSql = sourceSql;
        this.dbType = DBType.MYSQL;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.min = (currentPage - 1) * pageSize + 1;
        this.max = currentPage * pageSize;
        this.totalCount = 0;
    }

    public PageSql(String sourceSql,DBType dbType, int currentPage, int pageSize) {
        this.sourceSql = sourceSql;
        this.dbType = dbType;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.min = (currentPage - 1) * pageSize + 1;
        this.max = currentPage * pageSize;
    }

    public DBType getDbType() {
        return dbType;
    }

    public void setDbType(DBType dbType) {
        this.dbType = dbType;
    }

    public String getSourceSql() {
        return sourceSql;
    }

    public void setSourceSql(String sourceSql) {
        this.sourceSql = sourceSql;
    }

    public String getLimitSql() {
        return limitSql;
    }

    public void setLimitSql(String limitSql) {
        this.limitSql = limitSql;
    }
    
    public String getLimitSql(int totalCount) {
        this.totalCount=totalCount;
        if (totalCount < min) {
            currentPage = 1;
            min = 1;
            max = pageSize;
        }
        if (DBType.MYSQL.equals(this.dbType))
            this.limitSql = (new StringBuilder()).append("SELECT * FROM (")
                    .append(this.sourceSql).append(") T_T LIMIT ").append(min - 1)
                    .append(",").append((max - min) + 1).toString();
        else
            this.limitSql = (new StringBuilder()).append("SELECT * FROM (")
                    .append(this.sourceSql).append(") T_T LIMIT ").append(min - 1)
                    .append(",").append((max - min) + 1).toString();
        return limitSql;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setCountSql(String countSql) {
        this.countSql = countSql;
    }

    public String getCountSql() {
        if (DBType.MYSQL.equals(this.dbType))
            this.countSql = (new StringBuilder())
                    .append("SELECT COUNT(1) FROM (").append(this.sourceSql)
                    .append(") T").toString();
        else
            this.countSql = (new StringBuilder())
                    .append("SELECT COUNT(1) FROM (").append(this.sourceSql)
                    .append(") T").toString();
        this.min = (currentPage - 1) * pageSize + 1;
        this.max = currentPage * pageSize;
        if (totalCount < min) {
            currentPage = 1;
            min = 1;
            max = pageSize;
        }
        return this.countSql;
    }

}

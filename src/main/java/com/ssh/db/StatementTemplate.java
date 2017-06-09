package com.ssh.db;

import freemarker.template.Template;

public class StatementTemplate {
    private SqlType type;
    private DBType dbtype;
    
    private Template template;
    public StatementTemplate() {
    }

    public StatementTemplate(SqlType type, Template template) {
        super();
        this.type = type;
        this.template = template;
    }
    public DBType getDbtype() {
        return dbtype;
    }
    public StatementTemplate(SqlType type, DBType dbtype, Template template) {
        super();
        this.type = type;
        this.dbtype = dbtype;
        this.template = template;
    }
    public void setDbtype(DBType dbtype) {
        this.dbtype = dbtype;
    }
    public SqlType getType() {
        return type;
    }
    public void setType(SqlType type) {
        this.type = type;
    }
    public Template getTemplate() {
        return template;
    }
    public void setTemplate(Template template) {
        this.template = template;
    }
}

package com.ssh.db;

public enum SqlType {
    HQL("HQL"),
    SQL("SQL");
    private SqlType(String type) {
        Type = type;
    }

    public String Type;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}

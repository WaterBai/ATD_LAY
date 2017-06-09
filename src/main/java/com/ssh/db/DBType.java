package com.ssh.db;

public enum DBType {
    MYSQL("MYSQL");
    private DBType(String type) {
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

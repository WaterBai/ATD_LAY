package com.ssh.db;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.ssh.util.DateUtil;

public class DirectiveHandler {

    private Object object;

    // 增加多数据库支持则此处增加数据库操作
    // private Dialect dialect;

    public DirectiveHandler(Object object) {
        this.object = object;
        // this.dialect = dialect;
    }

    public boolean isArray() {
        if (object == null)
            return false;
        else
            return object.getClass().isArray();
    }

    public boolean isNotArray() {
        if (object == null)
            return true;
        else
            return !object.getClass().isArray();
    }

    public int length() {
        return stringValue().length();
    }

    public int size() {
        if (isArray())
            return Array.getLength(object);
        else
            return 1;
    }

    public String toLowerCase() {
        return stringValue().toLowerCase();
    }

    public String toUpperCase() {
        return stringValue().toUpperCase();
    }

    public String trim() {
        return stringValue().trim();
    }

    public String substring(int beginIndex, int endIndex) {
        return stringValue().substring(beginIndex, endIndex);
    }

    public String toDate(String format, String def) {
        String value = null;
        if (object instanceof Date) {
            value = DateUtil.formatDate((Date) object);
        } else {
            value = stringValue();
            Date dataValue = DateUtil.parseDate(value, format);
            if (dataValue != null)
                value = (new SimpleDateFormat(format)).format(dataValue);
        }
        if (value == null || value.equals(""))
            value = def;
        return value;
    }

    public boolean isNull() {
        return object == null;
    }

    public String isNull(String def) {
        if (isNull())
            return def;
        else
            return stringValue();
    }

    public boolean isNotNull() {
        return object != null;
    }

    public boolean isEmpty() {
        return stringValue().equals("");
    }

    public String isEmpty(String def) {
        if (isEmpty())
            return def;
        else
            return stringValue();
    }

    public boolean isNotEmpty() {
        return !stringValue().equals("");
    }

    public boolean equals(String str) {
        return stringValue().equals(str);
    }

    public boolean notEquals(String str) {
        return !stringValue().equals(str);
    }

    public boolean startsWith(String str) {
        return stringValue().startsWith(str);
    }

    public boolean endsWith(String str) {
        return stringValue().endsWith(str);
    }

    public int indexOf(String str) {
        return stringValue().indexOf(str);
    }

    public boolean isIp() {
        String ip = stringValue();
        return Pattern.matches("\\d{1,3}(\\.\\d{1,3}){3}", ip);
    }

    public String ip() {
        return ip("");
    }

    public String ip(String def) {
        String ip = stringValue();
        if (ip != null && !ip.equals("")) {
            if (isIp()) {
                String newip = "";
                String value[] = ip.split("\\.");
                for (int i = 0; i < value.length; i++)
                    newip = (new StringBuilder()).append(newip)
                            .append(fillStr(value[i], 3, "0")).append(".")
                            .toString();

                return newip.substring(0, newip.length() - 1);
            } else {
                return ip;
            }
        } else {
            return def;
        }
    }

    public String ipHex() {
        String ip = stringValue();
        if (isIp()) {
            String hex = "";
            String value[] = ip.split("\\.");
            for (int i = 0; i < value.length; i++) {
                int d = Integer.parseInt(value[i]);
                String hexstr = Integer.toHexString(d);
                if (hexstr.length() == 1)
                    hexstr = (new StringBuilder()).append("0").append(hexstr)
                            .toString();
                hex = (new StringBuilder()).append(hex).append(hexstr)
                        .toString();
            }

            return hex.toUpperCase();
        } else {
            return ip;
        }
    }

    public String ipLong() {
        if (isIp()) {
            String hex = ipHex();
            return String.valueOf(Long.parseLong(hex, 16));
        } else {
            return "";
        }
    }

    public String inValue() {
        if (object == null)
            return "";
        if (object.getClass().isArray()) {
            StringBuffer data = new StringBuffer();
            int length = Array.getLength(object);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(object, i);
                if (value == null || (value instanceof Number)) {
                    if (data.length() == 0)
                        data.append("(").append(
                                value != null ? value.toString() : "NULL");
                    else
                        data.append(",").append(
                                value != null ? value.toString() : "NULL");
                    continue;
                }
                if (data.length() == 0)
                    data.append("('")
                            .append(value.toString().replaceAll("'", "''"))
                            .append("'");
                else
                    data.append(",'")
                            .append(value.toString().replaceAll("'", "''"))
                            .append("'");
            }

            if (data.length() > 0)
                return data.append(")").toString();
            else
                return "";
        }
        if (object instanceof Number)
            return "(" + object.toString() + ")";
        else
            return "('" + toString() + "')";
    }

    public String orValue(String columnName) {
        if (object == null)
            return columnName + " IS NULL ";
        if (object.getClass().isArray()) {
            StringBuffer data = new StringBuffer();
            int length = Array.getLength(object);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(object, i);
                if (data.length() == 0)
                    data.append(" (").append(columnName);
                else
                    data.append(" OR ").append(columnName);
                if (value == null || (value instanceof Number)) {
                    if (value == null)
                        data.append(" IS NULL ");
                    else
                        data.append("=").append(value.toString());
                } else {
                    data.append("=").append("'").append(value.toString())
                            .append("'");
                }
            }

            return data.length() <= 0 ? "" : data.append(")").toString();
        } else {
            return (object instanceof Number) ? columnName + "="
                    + object.toString() : columnName + "=" + "'" + toString()
                    + "'";
        }
    }

    private String fillStr(String str, int length, String filestr) {
        String newstr = str;
        if (str.length() < length) {
            for (int i = 0; i < length - str.length(); i++)
                newstr = (new StringBuilder()).append(filestr).append(newstr)
                        .toString();

        }
        return newstr;
    }

    public String stringValue() {
        if (object == null)
            return "";
        if (object.getClass().isArray()) {
            if (Array.getLength(object) > 0) {
                Object obj = Array.get(object, 0);
                return obj == null ? "" : obj.toString();
            } else {
                return "";
            }
        } else {
            return object.toString();
        }
    }

    public String toString() {
        String str = stringValue();
        return str != null ? str.replaceAll("'", "''") : "";
    }

    public Object getObject() {
        return object;
    }

}

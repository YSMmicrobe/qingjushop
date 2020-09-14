package com.baizhi.entity;

import com.baizhi.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * (Syslog)实体类
 *id VARCHAR2(32) default SYS_GUID() PRIMARY KEY,
 *   visitTime timestamp,
 *   username VARCHAR2(50),
 *   ip VARCHAR2(30),
 *   url VARCHAR2(50),
 *   executionTime int,
 *   method VARCHAR2(200)
 */
public class Syslog implements Serializable {
    private String id;
    private Date visitTime;
    private String  visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVisitTimeStr() {
        if (visitTime != null){
            visitTimeStr = DateUtils.date2String(visitTime,"yyyy-MM-dd HH-mm");
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    @Override
    public String toString() {
        return "Syslog{" +
                "id='" + id + '\'' +
                ", visitTime=" + visitTime +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", executionTime=" + executionTime +
                ", method='" + method + '\'' +
                '}';
    }
}
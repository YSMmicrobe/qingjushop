package com.baizhi.dao;

import com.baizhi.entity.Syslog;

import java.util.List;

public interface ISysLogDao {
    void saveLog(Syslog syslog);
    List<Syslog> selectAll();
}

package com.baizhi.service;

import com.baizhi.entity.Syslog;

import java.util.List;

public interface ISysLogService {
    void saveLog(Syslog syslog);
    List<Syslog> selectAll();
}

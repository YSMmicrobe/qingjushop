package com.baizhi.service.impl;

import com.baizhi.dao.ISysLogDao;
import com.baizhi.entity.Syslog;
import com.baizhi.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void saveLog(Syslog syslog) {
        sysLogDao.saveLog(syslog);
    }

    @Override
    public List<Syslog> selectAll() {
        return sysLogDao.selectAll();
    }
}

package com.baizhi.service.impl;

import com.baizhi.dao.IPermissionDao;
import com.baizhi.entity.Permission;
import com.baizhi.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> selectAll() {
        return permissionDao.selectAll();
    }

    @Override
    public void insertOne(Permission permission) {
        permissionDao.insertOne(permission);
    }
}

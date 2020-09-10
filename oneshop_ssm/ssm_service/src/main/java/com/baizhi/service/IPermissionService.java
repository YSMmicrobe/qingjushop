package com.baizhi.service;

import com.baizhi.entity.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> selectAll();
}

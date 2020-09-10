package com.baizhi.dao;

import com.baizhi.entity.Permission;

import java.util.List;

public interface IPermissionDao {
    List<Permission> selectById(String id);
}

package com.baizhi.service;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;

import java.util.List;

public interface IRoleService {
    //
    Role selectRoleById(String userId);
    //
    List<Role> selectAll();
    //
    void insert(Role role);
    //删除角色
    void deleteOne(String roleId);
    //
    List<Permission> showPermissionNotInRole(String roleId);
    //添加权限
    void addPermissionToRole(String rolesId,String [] permissionIds);
}

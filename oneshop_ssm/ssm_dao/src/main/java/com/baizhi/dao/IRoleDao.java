package com.baizhi.dao;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRoleDao {
    //
    List<Role> selectRolesById(String userId);
    //
    Role selectRoleById(String id);
    //
    List<Role> selectAll();
    //添加角色
    void insert(Role role);
    //删除角色
    void deleteOne(String roleId);
    //删除角色所在的 用户-角色 中间表数据
    void deleteRoleConnectUser(String id);
    //删除角色所在的 权限-角色 中间表数据
    void deleteRoleConnectPermission(String id);
    //展示未拥有的权限
    List<Permission> showPermissionNotInRole(String roleId);
    //给角色添加权限
    void addPermissionToRole(@Param("roleId")String roleId,@Param("permissionIds")String[] permissionIds);
}

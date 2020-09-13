package com.baizhi.service.impl;

import com.baizhi.dao.IRoleDao;
import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public Role selectRoleById(String userId) {
        return roleDao.selectRoleById(userId);
    }

    @Override
    public List<Role> selectAll() {
        return roleDao.selectAll();
    }

    @Override
    public void insert(Role role) {
        roleDao.insert(role);
    }

    /**
     * 删除角色
     * 有两个外键
     * @param roleId
     */
    @Override
    public void deleteOne(String roleId) {
        roleDao.deleteRoleConnectUser(roleId);
        roleDao.deleteRoleConnectPermission(roleId);
        roleDao.deleteOne(roleId);
    }

    @Override
    public List<Permission> showPermissionNotInRole(String roleId) {
        return roleDao.showPermissionNotInRole(roleId);
    }

    @Override
    public void addPermissionToRole(String rolesId, String[] permissionIds) {
        roleDao.addPermissionToRole(rolesId,permissionIds);
    }
}

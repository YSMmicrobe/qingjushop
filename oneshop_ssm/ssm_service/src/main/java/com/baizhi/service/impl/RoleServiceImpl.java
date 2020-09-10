package com.baizhi.service.impl;

import com.baizhi.dao.IRoleDao;
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
    public List<Role> selectAll() {
        return roleDao.selectAll();
    }
}

package com.baizhi.dao;

import com.baizhi.entity.Role;

import java.util.List;

public interface IRoleDao {
    //
    List<Role> selectRolesById(String userId);
    //
    List<Role> selectAll();

}

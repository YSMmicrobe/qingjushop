package com.baizhi.service;

import com.baizhi.entity.Role;
import com.baizhi.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    //
    UserInfo selectById(String userId);
    //
    List<UserInfo> selectAll();
    //
    void insertOne(UserInfo userInfo);
    //
    List<Role> selectRoleNoInUser(String userId);
    //
    void addRoleToUser(String userId,String[] RoleId);
}

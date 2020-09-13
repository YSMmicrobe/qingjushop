package com.baizhi.dao;

import com.baizhi.entity.Role;
import com.baizhi.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    public UserInfo selectByName(String name);

    UserInfo selectById(String userId);

    List<UserInfo> selectAll();

    void insertOne(UserInfo userInfo);

    List<Role> selectRoleNoInUser(String userId);

    void addRoleToUser(@Param("userId") String userId,@Param("roleIds") String[] roleIds);

}

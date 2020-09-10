package com.baizhi.dao;

import com.baizhi.entity.UserInfo;

import java.util.List;

public interface IUserDao {
    public UserInfo selectByName(String name);

    UserInfo selectById(String userId);

    List<UserInfo> selectAll();

    void insertOne(UserInfo userInfo);

}

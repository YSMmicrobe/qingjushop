package com.baizhi.dao;

import com.baizhi.entity.Member;

public interface IMemberDao {
    public Member selectById(String id);
}

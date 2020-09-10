package com.baizhi.dao;

import com.baizhi.entity.Traveller;

import java.util.List;

public interface ITravellerDao {
    public List<Traveller> selectAllById(String id);
}

package com.baizhi.dao;

import com.baizhi.entity.Order;

import java.util.List;

public interface IOrderDao {
    /**
     * 查询所有订单
     */
    public List<Order> selectAll();

    /**
     * 根据id查询订单详情
     */
    public Order selectById(String id);
}

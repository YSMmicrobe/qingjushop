package com.baizhi.service;

import com.baizhi.entity.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> selectAll(int pageNum,int pageSize);

    /**
     * 根据id查询订单详情
     */
    public Order selectById(String id);
}

package com.baizhi.service.impl;

import com.baizhi.dao.IOrderDao;
import com.baizhi.dao.IProductDao;
import com.baizhi.entity.Order;
import com.baizhi.entity.Product;
import com.baizhi.service.IOrderService;
import com.baizhi.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Order> selectAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return orderDao.selectAll();
    }

    @Override
    public Order selectById(String id) {
        return orderDao.selectById(id);
    }

}

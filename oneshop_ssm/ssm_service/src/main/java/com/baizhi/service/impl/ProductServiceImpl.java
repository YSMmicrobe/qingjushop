package com.baizhi.service.impl;

import com.baizhi.dao.IProductDao;
import com.baizhi.entity.Product;
import com.baizhi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> selectAll() {
        return productDao.selectAll();
    }

    @Override
    public void insertOnePro(Product product) {
        productDao.insertOnePro(product);
    }
}

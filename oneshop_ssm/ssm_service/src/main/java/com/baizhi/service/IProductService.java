package com.baizhi.service;

import com.baizhi.entity.Product;

import java.util.List;

public interface IProductService {
    //
    public List<Product> selectAll();

    //
    public void insertOnePro(Product product);
}

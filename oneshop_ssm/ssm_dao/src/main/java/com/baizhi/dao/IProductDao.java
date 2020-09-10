package com.baizhi.dao;


import com.baizhi.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    //
    public Product selectById(String id);

    //查询所有的商品信息
    public List<Product> selectAll();

    //
    public void insertOnePro(Product product);
}

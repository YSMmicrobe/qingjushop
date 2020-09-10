package com.baizhi.controller;

import com.baizhi.entity.Product;
import com.baizhi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/selectAll")
    public ModelAndView selectAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.selectAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list");

        return mv;
    }

    /**
     * 添加订单
     * @return
     */
    @RequestMapping("/save")
    public String  insert(Product product){
        productService.insertOnePro(product);
        return "redirect:selectAll";
    }

}

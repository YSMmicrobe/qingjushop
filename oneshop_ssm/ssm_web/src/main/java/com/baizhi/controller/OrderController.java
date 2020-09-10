package com.baizhi.controller;

import com.baizhi.entity.Order;
import com.baizhi.service.IOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

//    /**
//     * 查询全部   未分页
//     * @return
//     */
//    @RequestMapping("/selectAll")
//    public ModelAndView selectAllOrder(){
//        ModelAndView mv = new ModelAndView();
//        List<Order> orders = orderService.selectAll();
//        mv.addObject("ordersList",orders);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    /**
     * 查询全部   分页
     * @return
     */
    @RequestMapping("/selectAll")
    public ModelAndView selectAllOrder(@RequestParam(name = "page",required = true, defaultValue = "1")int page,@RequestParam(name = "size",required = true, defaultValue = "3")int size){
        ModelAndView mv = new ModelAndView();
        List<Order> orders = orderService.selectAll(page, size);
        PageInfo<Order> pi = new PageInfo<>(orders);
        mv.addObject("pi",pi);
        mv.setViewName("orders-list");
        return mv;
    }

    /**
     * 订单详情
     * 根据id查询订单详情
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    public ModelAndView selectById(@RequestParam(name = "id")String  id){
        ModelAndView mv = new ModelAndView();
        Order order = orderService.selectById(id);
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }
}

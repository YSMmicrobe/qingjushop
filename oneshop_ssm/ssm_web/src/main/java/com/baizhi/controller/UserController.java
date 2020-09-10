package com.baizhi.controller;

import com.baizhi.entity.UserInfo;
import com.baizhi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询全部用户
     * @return
     */
    @RequestMapping("/selectAll")
    public ModelAndView selectAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userService.selectAll();
        mv.addObject("userList",userInfos);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 根据id查询用户详情
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView selectById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.selectById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 添加用户基本信息
     * @param userInfo
     * @return
     */
    @RequestMapping("/save")
    public String addUser(UserInfo userInfo){
        userService.insertOne(userInfo);
        return "redirect:selectAll";
    }


    /**
     *
     * @return
     */
    @RequestMapping("/selectUserByIdAndAllRole")
    public ModelAndView selectUserByIdAndAllRole(){
        ModelAndView mv = new ModelAndView();


        return mv;
    }
}

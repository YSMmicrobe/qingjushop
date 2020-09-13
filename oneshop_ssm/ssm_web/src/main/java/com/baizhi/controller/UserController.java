package com.baizhi.controller;

import com.baizhi.entity.Role;
import com.baizhi.entity.UserInfo;
import com.baizhi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
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
    @RolesAllowed("ADMIN")
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
    @Secured("ROLE_ADMIN")
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
     *  查询用户 以及 可以添加的 角色信息
     * @return
     */
    @RequestMapping("/selectUserByIdAndAllRole")
    public ModelAndView selectUserByIdAndAllRole(String id){
        ModelAndView mv = new ModelAndView();
        //
        UserInfo userInfo = userService.selectById(id);
        //
        List<Role> roles = userService.selectRoleNoInUser(id);
        mv.addObject("user",userInfo);
        mv.addObject("roles",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 给用户添加角色
     */
    @RequestMapping("/addRole")
    public String addRole(String userId,String [] ids){
        userService.addRoleToUser(userId,ids);
        return "redirect:selectAll";
    }
}

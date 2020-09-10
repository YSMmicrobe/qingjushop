package com.baizhi.controller;

import com.baizhi.entity.Role;
import com.baizhi.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/selectAll")
    public ModelAndView selectAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.selectAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");

        return mv;
    }

}

package com.baizhi.controller;

import com.baizhi.entity.Permission;
import com.baizhi.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/selectAll")
    public ModelAndView selectAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.selectAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/insert")
    public String insertOne(Permission permission){
        permissionService.insertOne(permission);
        return "redirect:selectAll";
    }
}

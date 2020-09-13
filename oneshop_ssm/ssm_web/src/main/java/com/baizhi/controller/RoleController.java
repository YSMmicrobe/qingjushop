package com.baizhi.controller;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    /**
     * selectByIdg
     */
//    @PreAuthorize("#id == authentication.principal.id")
    @RequestMapping("/selectById")
    public ModelAndView  selectByIdg(String id){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.selectRoleById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    /**
     * ��ѯȫ����ɫ
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping("/selectAll")
    public ModelAndView selectAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.selectAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * ���һ����ɫ
     * @param role
     * @return
     */
    @RequestMapping("/insert")
    public String insertRole(Role role){

        roleService.insert(role);
        return "redirect:selectAll";
    }

    /**
     * ɾ��һ����ɫ
     * ��ɾ��������ڵ�����
     */
    @RequestMapping("/delete")
    public String delectRole(String id){
        roleService.deleteOne(id);
        return "redirect:selectAll";
    }

    /**
     * ��չʾ��ɫδ�е�Ȩ��
     *
     */
    @RequestMapping("/showPermissionNotInRole")
    public ModelAndView showPermissionNotInRole(String id){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissions = roleService.showPermissionNotInRole(id);
        mv.addObject("roleId",id);
        mv.addObject("permissions",permissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    /**
     * ����ɫ���Ȩ��
     */
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String roleId,String[] ids){
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:selectAll";
    }
}

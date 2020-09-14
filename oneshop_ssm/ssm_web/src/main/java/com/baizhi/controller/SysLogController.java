package com.baizhi.controller;

import com.baizhi.entity.Syslog;
import com.baizhi.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/selectAll")
    public ModelAndView selectAll(){
        ModelAndView mv = new ModelAndView();
        List<Syslog> sysLogs = sysLogService.selectAll();
        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}

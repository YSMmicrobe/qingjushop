package com.baizhi.controller;

import com.baizhi.entity.Syslog;
import com.baizhi.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;

    private Date startTime; // 访问时间
    private Class executionClass;// 访问的类
    private Method executionMethod; // 访问的方法
    // 主要获取访问时间、访问的类、访问的方法

    //前置通知
    @Before("execution(* com.baizhi.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        // 访问时间
        startTime = new Date();
        // 获取访问的类
        executionClass = jp.getTarget().getClass();
        // 获取访问的方法
        String methodName = jp.getSignature().getName();// 获取访问的方法的名称
        Object[] args = jp.getArgs();// 获取访问的方法的参数
        if (args == null || args.length == 0) {// 无参数
            executionMethod = executionClass.getMethod(methodName); // 只能获取无参数方法
        } else {
            // 有参数，就将args中所有元素遍历，获取对应的Class,装入到一个Class[]
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            executionMethod = executionClass.getMethod(methodName, classArgs);// 获取有参数方法
        }
    }
    @After("execution(* com.baizhi.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        long executeTime = new Date().getTime()-startTime.getTime();
        //获取url
        // 获取类上的@RequestMapping对象
        if (executionClass != LogAop.class){
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            //进入访问日志信息的controller不记录
            if (classAnnotation != null && !classAnnotation.value()[0].equals("com.baizhi.controller.SysLogController")){
                //获取方法上的@RequestMapping对象
                RequestMapping methodAnnotation =  executionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null && !methodAnnotation.value()[0].equals("selectAll")){
                    String url = "";
                    url = classAnnotation.value()[0]+methodAnnotation.value()[0];
                    //获取访问的IP
                    String ip = request.getRemoteAddr();
                    //获取操作者
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文获取当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();
                    //
                    Syslog syslog = new Syslog();
                    syslog.setUsername(username);
                    syslog.setIp(ip);
                    syslog.setMethod("[类名]"+executionClass.getName()+" [方法名]"+executionMethod.getName());
                    syslog.setExecutionTime(executeTime);
                    syslog.setUrl(url);
                    syslog.setVisitTime(startTime);
                    sysLogService.saveLog(syslog);
                }
            }
        }


    }
}

package com.baizhi;

import com.baizhi.entity.UserInfo;
import com.baizhi.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestRole {
    @Autowired
    private IUserService userService;

    @Test
    public void select1(){
        UserInfo userInfo = userService.selectById("A7E6C525372A4769B9FAB1963F3E7243");
        userInfo.getRoles().forEach(System.out::println);
    }

    @Test
    public void selectRoleNoInUser(){
        userService.selectRoleNoInUser("A7E6C525372A4769B9FAB1963F3E7243").forEach(System.out::println);
    }
}

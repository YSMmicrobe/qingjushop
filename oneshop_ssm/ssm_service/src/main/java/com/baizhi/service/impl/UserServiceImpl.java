package com.baizhi.service.impl;

import com.baizhi.dao.IUserDao;
import com.baizhi.entity.Role;
import com.baizhi.entity.UserInfo;
import com.baizhi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.selectByName(username);

        //
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthoritie(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),
                "{noop}"+userInfo.getPassword(),
                userInfo.getStatus()==0?false:true,
                true,
                true,
                true,
                getAuthoritie(userInfo.getRoles()));
        return user;
    }

    /**
     * 返回一个list集合 集合中装入的是角色描述
     * @param roles
     * @return
     */
    private List<SimpleGrantedAuthority> getAuthoritie(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }

        return list;
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public UserInfo selectById(String userId) {
        return userDao.selectById(userId);
    }

    /**
     *
     * @return
     */
    @Override
    public List<UserInfo> selectAll() {
        return userDao.selectAll();
    }
}

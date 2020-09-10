package com.baizhi.service.impl;

import com.baizhi.dao.IMemberDao;
import com.baizhi.entity.Member;
import com.baizhi.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberSerciceImpl implements IMemberService {

    @Autowired
    private IMemberDao iMemberDao;

    @Override
    public Member selectById(String id) {
        return iMemberDao.selectById(id);
    }
}

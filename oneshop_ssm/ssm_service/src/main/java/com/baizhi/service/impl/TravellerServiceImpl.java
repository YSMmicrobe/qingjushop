package com.baizhi.service.impl;


import com.baizhi.dao.ITravellerDao;
import com.baizhi.entity.Traveller;
import com.baizhi.service.ItravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TravellerServiceImpl implements ItravellerService {
    @Autowired
    private ITravellerDao travellerDao;

    @Override
    public List<Traveller> selectAllById(String id) {
        return travellerDao.selectAllById(id);
    }
}

package com.baizhi.service;

import com.baizhi.entity.Traveller;

import java.util.List;

public interface ItravellerService {
    public List<Traveller> selectAllById(String id);

}

package com.lianbi.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lianbi.entity.StuEntity;
import com.lianbi.mapper.StuMapper;
import com.lianbi.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl extends ServiceImpl<StuMapper,StuEntity> implements StuService  {

    @Autowired
    StuMapper stuMapper;

    @Override
    public List<StuEntity> selectStu() {
        return stuMapper.selectStu();
    }

}

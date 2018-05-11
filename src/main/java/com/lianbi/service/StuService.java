package com.lianbi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lianbi.entity.StuEntity;

import java.util.List;

public interface StuService extends IService<StuEntity> {
    List<StuEntity> selectStu();
}

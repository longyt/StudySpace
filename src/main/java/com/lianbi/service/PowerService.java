package com.lianbi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lianbi.entity.Power;

import java.util.List;

public interface PowerService extends IService<Power> {
    List<Power> selectoptions(String logInfo);
}

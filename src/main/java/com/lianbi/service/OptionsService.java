package com.lianbi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lianbi.entity.Options;
import com.lianbi.entity.StuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OptionsService extends IService<Options> {
    List<Options> selectoptions(String logInfo);
}

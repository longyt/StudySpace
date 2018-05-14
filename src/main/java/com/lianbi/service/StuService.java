package com.lianbi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lianbi.entity.StuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuService extends IService<StuEntity> {
    List<StuEntity> selectStu();

    void InportExcel(@Param("list") List<StuEntity> StuList);
}

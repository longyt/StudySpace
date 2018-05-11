package com.lianbi.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lianbi.entity.StuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuMapper extends BaseMapper<StuEntity> {
    List<StuEntity> selectStu();
}

package com.lianbi.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lianbi.entity.Power;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerMapper extends BaseMapper<Power> {

    List<Power> selectoptions();

    List<Power> selectpower();

}

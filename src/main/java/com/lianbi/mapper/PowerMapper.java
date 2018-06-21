package com.lianbi.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lianbi.entity.Power;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PowerMapper extends BaseMapper<Power> {

    List<Power> selectoptions();

    List<Power> selectpower();

    Power selectPowerById(Map<String ,String > params);

    List<Power> selectParentPower(Map<String ,String > params);
}

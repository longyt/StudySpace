package com.lianbi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lianbi.entity.Power;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

public interface PowerService extends IService<Power> {
    List<Power> selectoptions(String logInfo);

    Map<String ,Object> selectpower(String logInfo, Map<String ,String > params);

    ModelMap selectPowerById (String logInfo, Map<String ,String > params);

}

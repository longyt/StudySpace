package com.lianbi.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lianbi.entity.Power;
import com.lianbi.mapper.PowerMapper;
import com.lianbi.service.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PowerServiceImpl extends ServiceImpl<PowerMapper, Power> implements PowerService {

    private static final Logger logger = LoggerFactory.getLogger(PowerServiceImpl.class);

    @Autowired
    private PowerMapper optionsMapper;

    @Override
    public List<Power> selectoptions(String logInfo) {
        logger.info(logInfo + "-开始查询数据");
        return optionsMapper.selectoptions();
    }

    @Override
    public Map<String, Object> selectpower(String logInfo, Map<String, String> params) {
        logger.info(logInfo + "-开始查询数据");

        Map<String, String> vo = new HashMap<>();
        String start = String.valueOf((Integer.parseInt(params.get("currentSelPage")) - 1) * Integer.parseInt(params.get("PageNum")));
        String end = String.valueOf(Integer.parseInt(params.get("currentSelPage")) * Integer.parseInt(params.get("PageNum")));
        vo.put("start", start);
        vo.put("end", end);
        List<Power> selectpower = optionsMapper.selectpower();

        Map<String, Object> result = new HashMap<>();
        result.put("resCode", "00001");
        if (selectpower == null) {
            result.put("resCode", "00003");
            result.put("resMsg", "查无数据");
            return result;
        }
        List<Power> powerList = selectpower.subList(Integer.parseInt(vo.get("start")), Integer.parseInt(vo.get("end")));
        result.put("powerList", powerList);
        result.put("powerListSize", selectpower.size());
        result.put("resCode", "00000");
        logger.info(logInfo + "查询完毕");
        return result;
    }

    @Override
    public ModelMap selectPowerById(String logInfo, Map<String, String> params) {
        logger.info(logInfo+"-查询数据");
        ModelMap modelMap=new ModelMap();
        modelMap.put("resCode","00001");
        Power power = optionsMapper.selectPowerById(params);
        if(power==null){
            modelMap.put("resCode","00003");
            modelMap.put("resMsg","用户不存在");
            logger.info(logInfo+"-用户不存在");
            return modelMap;
        }
        List<Power> parentPower = optionsMapper.selectParentPower(params);
        if(parentPower==null){
            modelMap.put("resCode","00003");
            modelMap.put("resMsg","父级用户不存在");
            logger.info(logInfo+"-父级用户不存在");
            return modelMap;
        }
        modelMap.put("resCode","00000");
        modelMap.put("power",power);
        modelMap.put("parentPower",parentPower);
        return modelMap;
    }



}

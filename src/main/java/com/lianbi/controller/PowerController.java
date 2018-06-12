package com.lianbi.controller;

import com.alibaba.fastjson.JSON;
import com.lianbi.core.ModelMap;
import com.lianbi.entity.Power;
import com.lianbi.service.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/power")
public class PowerController {

    private  static final Logger logger = LoggerFactory.getLogger(PowerController.class);

    @Autowired
    private PowerService powerService;

    @ResponseBody
    @RequestMapping("/list.action")
    public ModelMap select(){
        String logInfo="侧边栏";
        ModelMap modelMap=new ModelMap();
        modelMap.put("resCode","00001");
        List<Power> powerList = powerService.selectoptions(logInfo);
        if(powerList==null){
            logger.info(logInfo+"-查无数据");
            modelMap.put("resMsg","查无数据");
            return modelMap;
        }
        logger.info(logInfo+"-数据查询完成"+JSON.toJSONString(powerList));
        modelMap.put("resCode","00000");
        modelMap.put("options",powerList);
        return modelMap;
    }

    @RequestMapping("/powerlist.action")
    public String select(org.springframework.ui.ModelMap modelMap){
        String logInfo="权限管理";
        modelMap.put("resCode","00001");
        List<Power> powerList = powerService.selectoptions(logInfo);
        if(powerList==null){
            logger.info(logInfo+"-查询数据为空");
            modelMap.put("resCode","00003");
            modelMap.put("resMsg","查无数据");
            return "/page/error";
        }
        modelMap.put("resCode","00000");
        modelMap.put("result",powerList);
        return "/page/power";
    }


}

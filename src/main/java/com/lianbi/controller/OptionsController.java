package com.lianbi.controller;

import com.alibaba.fastjson.JSON;
import com.lianbi.core.ModelMap;
import com.lianbi.entity.Options;
import com.lianbi.service.OptionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/options")
public class OptionsController {

    private  static final Logger logger = LoggerFactory.getLogger(OptionsController.class);

    @Autowired
    private OptionsService optionsService;

    @ResponseBody
    @RequestMapping("/list.action")
    public ModelMap select(){
        String logInfo="侧边栏";
        ModelMap modelMap=new ModelMap();
        modelMap.put("resCode","00001");
        List<Options> selectoptions = optionsService.selectoptions(logInfo);
        if(selectoptions==null){
            logger.info(logInfo+"-查无数据");
            modelMap.put("resMsg","查无数据");
            return modelMap;
        }
        logger.info(logInfo+"-数据查询完成"+JSON.toJSONString(selectoptions));
        modelMap.put("resCode","00000");
        modelMap.put("options",selectoptions);
        return modelMap;
    }



}

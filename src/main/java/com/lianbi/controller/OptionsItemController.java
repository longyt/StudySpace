package com.lianbi.controller;

import com.lianbi.core.ModelMap;
import com.lianbi.entity.Options;
import com.lianbi.entity.OptionsItem;
import com.lianbi.service.OptionsItemService;
import com.lianbi.service.OptionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/optionsitem")
public class OptionsItemController {

    private  static final Logger logger = LoggerFactory.getLogger(OptionsItemController.class);

    @Autowired
    private OptionsItemService optionsItemService;

    @ResponseBody
    @RequestMapping("/list.action")
    public ModelMap select(String optionItemPid){
        String logInfo="item";
        ModelMap modelMap=new ModelMap();
        modelMap.put("resCode","00001");
        if (optionItemPid==null){
            logger.info(logInfo+"-optionItemPid     optionItemPid="+optionItemPid);
            modelMap.put("resMsg","参数optionItemPid传入为空");
            return modelMap;
        }
        List<OptionsItem> optionsItem =  optionsItemService.SelectOptionsById(optionItemPid,logInfo);
        if(optionsItem==null){
            logger.info(logInfo+"-查无数据");
            modelMap.put("resMsg","查无数据");
            return modelMap;
        }
        logger.info(logInfo+"-数据查询完成");
        modelMap.put("resCode","00000");
        modelMap.put("optionsitem",optionsItem);
        return modelMap;
    }



}

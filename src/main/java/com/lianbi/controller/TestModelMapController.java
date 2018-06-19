package com.lianbi.controller;

import com.lianbi.core.ModelMap;
import com.lianbi.entity.StuEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequestMapping(value = "/modelmap")
public class TestModelMapController {

    private static final Logger logger = LoggerFactory.getLogger(StuController.class);

    @RequestMapping("/jump.action")
    public String Jump() {
        String logInfo = "ModelMap";

        logger.info(logInfo + "-开始跳转页面");
        return "modelmap";
    }


    @ResponseBody
    @RequestMapping("/select.action")
    public ModelMap select() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("resMsg", "00000");
        modelMap.put("stu", new StuEntity("longyt", "男", 11));
        return modelMap;
    }

}

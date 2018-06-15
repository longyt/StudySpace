package com.lianbi.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.ui.ModelMap;
import com.lianbi.entity.Power;
import com.lianbi.service.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String select(ModelMap modelMap, @RequestParam(defaultValue = "1") String  currentSelPage, @RequestParam(defaultValue = "5") String  PageNum){
        String logInfo="权限管理";
        Map<String ,String > params = new HashMap<>();
        logger.info("-----------------------"+currentSelPage);
        if(currentSelPage==null){
            logger.info(logInfo+"-currentSelPage 参数为空");
            modelMap.put("resCode","00003");
            modelMap.put("resMsg","参数为空");
            return "/page/error";
        }
        if(PageNum==null){
            logger.info(logInfo+"-currentSelPage 参数为空");
            modelMap.put("resCode","00003");
            modelMap.put("resMsg","参数为空");
            return "/page/error";
        }
        params.put("currentSelPage",currentSelPage);
        params.put("PageNum",PageNum);

        Map<String, Object> selectMap = powerService.selectpower(logInfo, params);

        if(selectMap.get("resCode")!="00000"){
            logger.info(logInfo+"-查无数据");
            modelMap.put("resCode","00003");
            modelMap.put("resMsg","查无数据");
            return "/page/error";
        }
        logger.info(JSON.toJSONString(selectMap.get("powerList")));
        modelMap.put("resCode","00000");
        modelMap.put("powerList",selectMap.get("powerList"));
        modelMap.put("pageTotal",selectMap.get("powerListSize"));
        modelMap.put("currentSelPage",currentSelPage);
        modelMap.put("PageNum",PageNum);

        return "/page/power";
    }

    @RequestMapping("/test.action")
    public void test(){
        logger.info("成功了 yes");
    }


}

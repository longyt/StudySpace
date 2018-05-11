package com.lianbi.controller;

import com.alibaba.fastjson.JSON;
import com.lianbi.core.ResultDTO;
import com.lianbi.core.base.BaseController;
import com.lianbi.entity.StuEntity;
import com.lianbi.service.StuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/stu")
public class StuController extends BaseController {

   private  static final  Logger logger = LoggerFactory.getLogger(StuController.class);

    @Autowired
    StuService stuService;

    @RequestMapping(value = "/select.action")
    public void   SelectStu(HttpServletResponse response){
        try {
            logger.info(" ===     年轻人我进来了   ==="+stuService.selectStu().size());
            List<StuEntity> stuEntities = stuService.selectStu();
            ResultDTO resultDTO = new ResultDTO(stuEntities);
            logger.info(resultDTO.getResMsg() +"  ===  "+resultDTO.getResCode()+ "===   "+resultDTO.getResMsgType());
            this.outWrite(response,resultDTO);
        }catch (Exception e){
            this.outWrite(response,ResultDTO.Fail("处理失败"));
            logger.error("    ===  controller error "+e);
            logger.info("  ==   controller Exception");
        }
        logger.info("  ==  controller   处理完成  ");
       /* Map<String ,Object> map=new HashMap<>();
        map.put("data",stuEntities);
        String s = JSON.toJSONString(map);
        return s;
        */

    }

}

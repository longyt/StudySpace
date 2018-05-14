package com.lianbi.controller;

import com.lianbi.core.ResultDTO;
import com.lianbi.core.base.BaseController;
import com.lianbi.entity.StuEntity;
import com.lianbi.service.StuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/stu")
public class StuController extends BaseController {

   private  static final  Logger logger = LoggerFactory.getLogger(StuController.class);

    @Autowired
    StuService stuService;

    @RequestMapping(value = "/select.action")
    @ResponseBody
    public ResultDTO   SelectStu(HttpServletResponse response){
        ResultDTO resultDTO = null;
        try {
            logger.info(" ===     年轻人我进来了   ==="+stuService.selectStu().size());
            List<StuEntity> stuEntities = stuService.selectStu();
            resultDTO = new ResultDTO(stuEntities);
            logger.info(resultDTO.getResMsg() +"  ===  "+resultDTO.getResCode()+ "===   "+resultDTO.getResMsgType());
            this.outWrite(response,resultDTO);
        }catch (Exception e){
            this.outWrite(response,ResultDTO.Fail("处理失败"));
            logger.error("    ===  controller error "+e);
            logger.info("  ==   controller Exception");
        }
            logger.info("  ==  controller   处理完成  ");

            return  resultDTO;
    }

    @RequestMapping("/insert.action")
    public void InsertStu(HttpServletResponse response){
        StuEntity stuEntity=new StuEntity("jkk","男",22);
        if (StringUtils.isEmpty(stuEntity)){
            logger.info(" ===   StuEntity 不能为空 ");
        }
        stuService.insert(stuEntity);
        logger.info(" === StuEntity   添加成功   ");
        this.outWrite(response,new ResultDTO(stuEntity));
    }

}

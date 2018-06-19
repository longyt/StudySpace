package com.lianbi.controller;

import com.alibaba.fastjson.JSON;
import com.lianbi.core.ResultDTO;
import com.lianbi.core.base.BaseController;
import com.lianbi.core.util.ReadExcelDate;
import com.lianbi.entity.StuEntity;
import com.lianbi.service.StuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/stu")
public class StuController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(StuController.class);

    @Autowired
    StuService stuService;

    @RequestMapping(value = "/select.action")
    @ResponseBody
    public Object SelectStu(HttpServletResponse response) {
        ResultDTO resultDTO = null;
        try {
            logger.info(" ===     年轻人我进来了   ===" + stuService.selectStu().size());
            List<StuEntity> stuEntities = stuService.selectStu();
            resultDTO = new ResultDTO(stuEntities);
            logger.info(resultDTO.getResMsg() + "  ===  " + resultDTO.getResCode() + "===   " + resultDTO.getResMsgType());
            this.outWrite(response, resultDTO);
        } catch (Exception e) {
            this.outWrite(response, ResultDTO.Fail("处理失败"));
            logger.error("    ===  controller error " + e);
            logger.info("  ==   controller Exception");
        }
        logger.info("  ==  controller   处理完成  ");

        return JSON.toJSONString(resultDTO);
    }

    @RequestMapping("/insert.action")
    public void InsertStu(HttpServletResponse response) {
        logger.info("insert");
        StuEntity stuEntity = new StuEntity("ok", "女", 92);

        if (StringUtils.isEmpty(stuEntity)) {
            logger.info(" ===   StuEntity 不能为空 ");
        }
        stuService.insert(stuEntity);
        logger.info(" === StuEntity   添加成功   ");
        this.outWrite(response, new ResultDTO(stuEntity));
    }

    @RequestMapping("/update.action")
    public void updateStu(HttpServletResponse response) {
        logger.info("update");
        StuEntity stuEntity = new StuEntity();
        stuEntity.setId("11");
        stuEntity.setName("aaa");
        stuEntity.setSex("女");
        stuEntity.setAge(89);
        boolean b = stuService.updateById(stuEntity);
        System.out.println(b);
        if (!b) {
            logger.info(" ===   更新失败 ");
        }
        logger.info(" ===   更新成功 ");
        this.outWrite(response, new ResultDTO(stuEntity));
    }

    /**
     * 批量导入
     */
    @RequestMapping("/importfile.action")
    public Object ImportFile(HttpServletRequest request, MultipartFile file) {

        logger.info("进入到controller ");
        ResultDTO resultDTO = new ResultDTO();
        if (file == null || file.getSize() < 0) {
            logger.info("导入数据为空");
            return JSON.toJSONString(resultDTO.Fail("导入数据不能为空"));
        }
        String FileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        if (!FileSuffix.equals("xlsx")) {
            logger.info("导入数据格式不是xlsx");
            return JSON.toJSONString(resultDTO.Fail("导入数据格式不是xlsx"));
        }

        String FilePath = request.getSession().getServletContext().getRealPath("/") + "/UploadFile/" + new Date().getTime() + "." + FileSuffix;
        File file1 = new File(FilePath);
        if (!file1.getParentFile().exists()) {
            logger.info("创建父类文件夹");
            logger.info(String.valueOf(file1.getParentFile()));
            file1.getParentFile().mkdir();
        }
        List<String[]> allExcelData;
        try {
            logger.info("开始上传文件");
            file.transferTo(file1);
            allExcelData = ReadExcelDate.getAllExcelData(new FileInputStream(file1), FileSuffix);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("文件解析异常");
            return JSON.toJSONString(resultDTO.Fail("文件解析异常"));
        }

        if (allExcelData == null) {
            logger.info("文件解析异常");
            return JSON.toJSONString(resultDTO.Fail("文件解析异常"));
        }
        List<StuEntity> StuList = new LinkedList<>();
        logger.info("开始将数据转化list集合   size==" + allExcelData.size());
        for (int i = 0; i < allExcelData.size(); i++) {
            StuEntity stuEntity = new StuEntity();
            stuEntity.setName(allExcelData.get(i)[0]);
            stuEntity.setSex(allExcelData.get(i)[1]);
            Integer age = Integer.parseInt(allExcelData.get(i)[2].substring(0, allExcelData.get(i)[2].indexOf(".")));
            stuEntity.setAge(age);
            StuList.add(stuEntity);
        }
        logger.info(JSON.toJSONString(StuList));
        stuService.InportExcel(StuList);
        logger.info("解析成功");
        return JSON.toJSONString(resultDTO.Fail("解析成功"));


    }


}

package com.lianbi.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lianbi.entity.StuEntity;
import com.lianbi.mapper.StuMapper;
import com.lianbi.service.StuService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl extends ServiceImpl<StuMapper, StuEntity> implements StuService {

    private static final Logger logger = LoggerFactory.getLogger(StuServiceImpl.class);

    private static final Integer IMPORT_COUNT = 1000;

    private static final String NAMESPACE = "com.lianbi.mapper.StuMapper";

    @Autowired
    StuMapper stuMapper;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    public List<StuEntity> selectStu() {
        return stuMapper.selectStu();
    }


    public void InportExcel(@Param("list") List<StuEntity> StuList) {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
            int count = StuList.size() / IMPORT_COUNT;
            int allcount = 0;
            logger.info("开始导入");
            for (int i = 0; i < count; i++) {
                allcount = (i + 1) * IMPORT_COUNT;
                sqlSession.insert("com.lianbi.mapper.StuMapper.InsertDate", StuList.subList((i * IMPORT_COUNT), allcount));
                sqlSession.commit();
            }
            if (allcount < StuList.size()) {
                logger.info("我在这里");
                logger.info(JSON.toJSONString(StuList.subList(allcount, StuList.size())));
                int insert = sqlSession.insert("com.lianbi.mapper.StuMapper.InsertDate", StuList.subList(allcount, StuList.size()));
                logger.info(String.valueOf(insert));
                //logger.info(JSON.toJSONString(StuList.subList(allcount,StuList.size())));
                sqlSession.commit();
            }
            logger.info("导入完成");
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

}

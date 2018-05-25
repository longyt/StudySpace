package com.lianbi.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lianbi.controller.OptionsController;
import com.lianbi.entity.Options;
import com.lianbi.mapper.OptionsMapper;
import com.lianbi.service.OptionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OptionsServiceImpl extends ServiceImpl<OptionsMapper,Options> implements OptionsService {

    private  static final Logger logger = LoggerFactory.getLogger(OptionsServiceImpl.class);

    @Autowired
    private OptionsMapper optionsMapper;

    @Override
    public List<Options> selectoptions(String logInfo) {
        logger.info(logInfo+"-开始查询数据");
        return optionsMapper.selectoptions();
    }
}

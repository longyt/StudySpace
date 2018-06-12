package com.lianbi.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lianbi.entity.Power;
import com.lianbi.mapper.PowerMapper;
import com.lianbi.service.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PowerServiceImpl extends ServiceImpl<PowerMapper,Power> implements PowerService {

    private  static final Logger logger = LoggerFactory.getLogger(PowerServiceImpl.class);

    @Autowired
    private PowerMapper optionsMapper;

    @Override
    public List<Power> selectoptions(String logInfo) {
        logger.info(logInfo+"-开始查询数据");
        return optionsMapper.selectoptions();
    }
}

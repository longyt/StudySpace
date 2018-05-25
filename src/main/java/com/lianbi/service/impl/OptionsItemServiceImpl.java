package com.lianbi.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lianbi.entity.Options;
import com.lianbi.entity.OptionsItem;
import com.lianbi.mapper.OptionsItemMapper;
import com.lianbi.mapper.OptionsMapper;
import com.lianbi.service.OptionsItemService;
import com.lianbi.service.OptionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OptionsItemServiceImpl extends ServiceImpl<OptionsItemMapper,OptionsItem> implements OptionsItemService {

    private  static final Logger logger = LoggerFactory.getLogger(OptionsItemServiceImpl.class);

    @Autowired
    private OptionsItemMapper optionsItemMapper;


    @Override
    public List<OptionsItem> SelectOptionsById(String id,String logInfo) {
        logger.info(logInfo+"-开始查询");
        return optionsItemMapper.SelectOptionsById(id);
    }
}

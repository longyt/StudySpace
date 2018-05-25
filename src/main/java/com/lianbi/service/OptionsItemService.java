package com.lianbi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lianbi.entity.Options;
import com.lianbi.entity.OptionsItem;

import java.util.List;

public interface OptionsItemService extends IService<OptionsItem> {
    List<OptionsItem> SelectOptionsById(String id,String logInfo);
}

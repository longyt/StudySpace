package com.lianbi.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lianbi.entity.Options;
import com.lianbi.entity.OptionsItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionsItemMapper extends BaseMapper<OptionsItem> {

    List<OptionsItem> SelectOptionsById(String id);

}

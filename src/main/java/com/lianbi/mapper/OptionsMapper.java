package com.lianbi.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lianbi.entity.Options;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OptionsMapper extends BaseMapper<Options> {

    List<Options> selectoptions();

}

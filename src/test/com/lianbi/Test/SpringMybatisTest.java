package com.lianbi.Test;

import com.lianbi.mapper.StuMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisTest {

    @Test
    public void SpringMybatisTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        StuMapper stuMapper = (StuMapper) context.getBean("StuMapper");
        System.out.println("size == "+stuMapper.selectStu().size());
    }
}

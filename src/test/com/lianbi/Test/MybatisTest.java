package com.lianbi.Test;

import com.lianbi.mapper.StuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;


public class MybatisTest {

    @Test
    public void MybatisTest(){
        try {
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            SqlSession sqlSession = sqlSessionFactory.openSession();
            StuMapper mapper = sqlSession.getMapper(StuMapper.class);
            System.out.println("size == "+mapper.selectStu().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

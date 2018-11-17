package com.heidsoft.heidsoftmybatis;

import com.heidsoft.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @program: heidsoft-mybatis
 * @description: 测试mapper
 * @author: heidsoft
 * @create: 2018-11-17 14:42
 **/

public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            List<Country> countryList = sqlSession.selectList("selectAll");
        }finally {
            //关闭session
            sqlSession.close();
        }

    }

    private void printCountryList(List<Country> countryList){
        for (Country country : countryList) {
            System.out.println(country.getCountryName());
        }
    }
}

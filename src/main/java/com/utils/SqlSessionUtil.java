package com.utils;

import com.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public  static SqlSession sqlSession;
    public  static SqlSession getSqlSession(){
        try {
            InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(stream);
             sqlSession = build.openSession(true);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}

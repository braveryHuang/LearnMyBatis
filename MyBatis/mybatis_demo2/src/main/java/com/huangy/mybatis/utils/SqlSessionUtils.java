package com.huangy.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {

    private static final Logger log = Logger.getLogger(SqlSessionUtils.class);

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try {
            //Ctrl+Alt+V 自动生产变量名
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            log.error(e);
        }
        return sqlSession;
    }
}

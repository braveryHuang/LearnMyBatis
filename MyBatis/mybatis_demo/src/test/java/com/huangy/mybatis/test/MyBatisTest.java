package com.huangy.mybatis.test;

import com.huangy.mybatis.mapper.UserMapper;
import com.huangy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    /**
     * SqlSession 默认不自动提交事务，若需要自动提交事务
     * 可以使用 sqlSessionFactory.openSession(true);
     * @throws IOException
     */
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //获取sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession(代表java程序和数据库之间的会话)
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象(动态代理)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        int result = mapper.insertUser();
        //提交事务(这里需要提交事务，是因为核心配置中，使用的是JDBC)
        //sqlSession.commit();
        System.out.println("result = " + result);
    }

    @Test
    public void testCRUD() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //获取sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession(代表java程序和数据库之间的会话)
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象(动态代理)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        //mapper.updateUser();
        //mapper.deleteUser();
        /*User user = mapper.getUserById();
        System.out.println("user = " + user);*/
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
    }
}

package com.huangy.mybatis.test;

import com.huangy.mybatis.mapper.SQLMapper;
import com.huangy.mybatis.mapper.SelectMapper;
import com.huangy.mybatis.pojo.User;
import com.huangy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SQLMapperTest {

    @Test
    public void testGetUserByLike() {
        SqlSession  sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
    }

    @Test
    public void testDeleteMore() {
        SqlSession  sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("1,2,3");
        System.out.println(result);
    }

    @Test
    public void testGetUserByTableName() {
        SqlSession  sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> users = mapper.getUserByTableName("t_user");
        System.out.println(users);
    }

    @Test
    public void testInsertUser() {
        SqlSession  sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(0, "王五", "123", 23, '男', "abc@126.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}

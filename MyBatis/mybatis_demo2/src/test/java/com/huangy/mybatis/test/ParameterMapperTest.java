package com.huangy.mybatis.test;

import com.huangy.mybatis.mapper.ParameterMapper;
import com.huangy.mybatis.pojo.User;
import com.huangy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ParameterMapperTest {

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
    }
}

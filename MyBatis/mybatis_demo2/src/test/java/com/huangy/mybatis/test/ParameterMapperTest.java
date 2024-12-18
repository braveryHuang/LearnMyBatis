package com.huangy.mybatis.test;

import com.huangy.mybatis.mapper.ParameterMapper;
import com.huangy.mybatis.pojo.User;
import com.huangy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {

    /**
     * MyBatis 获取参数值的两种方式：${} 和 #{}
     * ${} 本质字符串拼接
     * #{} 本质占位符赋值
     * MyBatis 获取参数值的各种情况：
     * 1. mapper接口方法的参数为单个的字面量类型
     * 可以通过${} 和 #{} 以任意的名称来获取参数值，但是需要${}的单引号问题
     * 2. mapper接口方法的参数为多个时
     * 此时，MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a> 以arg0，arg1...为键，以参数为值
     * b> 以param1，param2...为键，以参数为值
     * 因此只需要通过 #{}和 ${} 以键的方式访问值即可，但是需要${}的单引号问题
     * 3. 若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
     * 只需要通过 #{}和 ${} 以键的方式访问值即可，但是需要${}的单引号问题
     * 4. mapper接口方法的参数是实体类类型的参数
     * 只需要通过 #{}和 ${} 以属性的方式访问属性值即可，但是需要${}的单引号问题
     * 5. 使用@Param注解命名参数
     * 此时，MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a> 以@param注解的值为键，以参数为值
     * b> 以param1，param2...为键，以参数为值
     * 因此只需要通过 #{}和 ${} 以键的方式访问值即可，但是需要${}的单引号问题
     * <p>
     * ***********************************************
     * 建议以上用法，就是用两种，一种全用@Param，一种是实体类对象
     */

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("张三", "123456");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        mapper.insertUser(new User(-1, "李四", "123", 23, '男', "email.com"));
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("张三", "123456");
        System.out.println(user);
    }

    @Test
    public void testUserByUserName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByName("张三");
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
    }
}

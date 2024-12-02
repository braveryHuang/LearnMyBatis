package com.huangy.mybatis.mapper;

import com.huangy.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    /**
     * 验证登录（使用@Param注解）
     */
    User checkLoginByParam(@Param("name") String name, @Param("password") String password);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 验证登录
     */
    User checkLogin(String username, String password);

    /**
     * 根据用户名来查询用户信息
     *
     * @return
     */
    User getUserByName(String username);

    List<User> getAllUser();
}

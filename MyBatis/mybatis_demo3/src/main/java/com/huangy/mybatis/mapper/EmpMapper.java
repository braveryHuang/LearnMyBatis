package com.huangy.mybatis.mapper;


import com.huangy.mybatis.pojo.Emp;

import java.util.List;

public interface EmpMapper {

    /**
     * 获取所有用户
     */
    List<Emp> getAllEmp();
}

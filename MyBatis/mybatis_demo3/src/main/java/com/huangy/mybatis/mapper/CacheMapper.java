package com.huangy.mybatis.mapper;


import com.huangy.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CacheMapper {

    /**
     * 获取所有用户
     */
    List<Emp> getAllEmp();
}

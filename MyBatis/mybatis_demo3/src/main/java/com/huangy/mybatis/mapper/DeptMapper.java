package com.huangy.mybatis.mapper;


import com.huangy.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 通过分步查询，查询员工以及员工所对应的部门信息
     * 分布查询第二步，通过did查询员工所对应的部门
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

}

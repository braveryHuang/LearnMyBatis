package com.huangy.mybatis.pojo;

import lombok.Data;

@Data
public class Emp {
    private Integer eid;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
    private int did;

    private Dept dept;
}

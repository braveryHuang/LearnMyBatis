package com.huangy.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emp implements Serializable {
    private Integer eid;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
    private int did;

    private Dept dept;
}

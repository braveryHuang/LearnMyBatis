package com.huangy.mybatis.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private char male;
    private String email;
}

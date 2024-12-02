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

    public User(int id, String name, String password, int age, char male, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.male = male;
        this.email = email;
    }
}

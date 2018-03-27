package com.study.edu.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/13.
 */
public class User implements Serializable {
    private Long id;
    private String userName;
    private String password;
    private SexNum sex;
    private String nickName;

    public User() {
    }

    public User(String userName, String password, SexNum sex) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SexNum getSex() {
        return sex;
    }

    public void setSex(SexNum sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}

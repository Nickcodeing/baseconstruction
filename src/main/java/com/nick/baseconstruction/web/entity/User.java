package com.nick.baseconstruction.web.entity;

import java.util.Date;


public class User {

    private int id;
    private String userName;
    private int age;
    private String sex;
    private Date createTime;

    public User(String userName,String sex,int age){
        this.userName = userName;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}

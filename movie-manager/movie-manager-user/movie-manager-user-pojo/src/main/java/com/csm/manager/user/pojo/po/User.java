package com.csm.manager.user.pojo.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: GCC
 * @Github: https://github.com/littlechenchao
 * @Date: 2018/11/8 17:56
 * @Version 1.0
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String uphone;
    private String upicture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUpicture() {
        return upicture;
    }

    public void setUpicture(String upicture) {
        this.upicture = upicture;
    }
}

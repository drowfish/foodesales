package com.smbms.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer level;

    private Integer headimg;

    private Date registeTime;

    public User(Integer id, String username, String password, Integer level, Integer headimg, Date registeTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.level = level;
        this.headimg = headimg;
        this.registeTime = registeTime;
    }

    public User() {
        super();
    }

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
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getHeadimg() {
        return headimg;
    }

    public void setHeadimg(Integer headimg) {
        this.headimg = headimg;
    }

    public Date getRegisteTime() {
        return registeTime;
    }

    public void setRegisteTime(Date registeTime) {
        this.registeTime = registeTime;
    }
}
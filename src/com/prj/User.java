package com.prj;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String nickName;
    private String password;

    public User() {}

    public User(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }
    public User(int id, String nickName, String password) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName +
                '}';
    }
}

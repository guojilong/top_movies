package com.gjl.topmovies.model;

import org.springframework.stereotype.Repository;

/**
 * Created by guojilong on 2017/10/18.
 */
@Repository
public class User {

    private int userId;
    private String UserName = "default user";
    private String UserEmail;
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", UserName=" + UserName
                + ", UserEmail=" + UserEmail + "]";
    }


}
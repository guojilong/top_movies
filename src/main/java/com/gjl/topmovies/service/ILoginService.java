package com.gjl.topmovies.service;

import com.gjl.topmovies.pojo.User;

/**
 * Created by guojilong on 2017/10/24.
 */
public interface ILoginService {
    public User login(String username, String pwd);
}

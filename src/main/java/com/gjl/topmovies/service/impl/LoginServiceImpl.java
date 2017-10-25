package com.gjl.topmovies.service.impl;

import com.gjl.topmovies.pojo.User;
import com.gjl.topmovies.service.ILoginService;
import org.springframework.stereotype.Component;

/**
 * Created by guojilong on 2017/10/24.
 */
@Component("loginService")
public class LoginServiceImpl implements ILoginService {
    public User login(String username, String pwd) {
        System.out.println("login succ :" + username);
        return null;
    }
}

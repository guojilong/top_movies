package com.gjl.topmovies.service.impl;

import com.gjl.topmovies.mapper.UserDao;
import com.gjl.topmovies.pojo.User;
import com.gjl.topmovies.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guojilong on 2017/10/24.
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService {

    @Autowired
    UserDao userDao;

    public User login(String username, String pwd) {
        List<User> userList=userDao.getUserByName(username);
        if (userList==null||userList.size()==0) {
            System.out.println("user not exist:" + username);

        }else {
            System.out.println("login succ :" + username);

        }
        return null;
    }
}

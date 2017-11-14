package com.gjl.topmovies.service.impl;

import com.gjl.topmovies.dto.LoginUser;
import com.gjl.topmovies.mapper.UserDao;
import com.gjl.topmovies.model.Response;
import com.gjl.topmovies.model.User;
import com.gjl.topmovies.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guojilong on 2017/10/24.
 */
@Service("loginService")
public class LoginServiceImpl {

    @Autowired
    UserDao userDao;

    public Response<LoginUser> login(String username, String pwd) {
        List<User> userList = userDao.getUserByNameOrEmail(username);
        if (userList == null || userList.size() == 0) {

            return Response.notOk("user not exist!");

        } else {

            User user = userList.get(0);

            if (pwd.equalsIgnoreCase(user.getPassword())) {

                LoginUser loginUser = new LoginUser();
                loginUser.setUsername(username);
                loginUser.setToken("token" + System.currentTimeMillis());
                return Response.ok(loginUser);
            } else {
                return Response.notOk("password error!");
            }

        }

    }
}

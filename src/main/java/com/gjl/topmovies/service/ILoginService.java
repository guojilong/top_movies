package com.gjl.topmovies.service;

import com.gjl.topmovies.model.Response;
import com.gjl.topmovies.model.User;

/**
 * Created by guojilong on 2017/10/24.
 */
public interface ILoginService {
      Response<User> login(String username, String pwd);
}

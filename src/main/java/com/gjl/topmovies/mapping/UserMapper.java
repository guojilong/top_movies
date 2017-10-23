package com.gjl.topmovies.mapping;

import com.gjl.topmovies.pojo.User;

import java.util.List;


/**
 * Created by guojilong on 2017/10/18.
 */
public interface UserMapper {

    public int insert(User user);

    public int update(User user);

    public int delete(String userName);

    public List<User> getAllUser();

    public User getUserById();


}
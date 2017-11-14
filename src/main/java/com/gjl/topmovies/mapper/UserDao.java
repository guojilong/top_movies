package com.gjl.topmovies.mapper;

import com.gjl.topmovies.model.User;

import java.util.List;


/**
 * Created by guojilong on 2017/10/18.
 */

public interface UserDao {

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUser(String userId);

    public List<User> getAllUser();


    public User getUserById(int id);


    public List<User> getUserByName(String name);


    public List<User> getUserByNameAndEmail(String username, String email);

    public List<User> getUserByNameOrEmail(String username);
}
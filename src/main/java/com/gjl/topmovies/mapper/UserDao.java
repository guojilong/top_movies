package com.gjl.topmovies.mapper;

import com.gjl.topmovies.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

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
}
package com.gjl.topmovies.mapping;

import com.gjl.topmovies.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * Created by guojilong on 2017/10/18.
 */
public interface UserMapper {

    @Insert("insert into user (UserName, UserEmail) values (\n" +
            "        #{UserName}, #{UserEmail}\n" +
            "        )")
    public int insert(User user);

    @Update("update user set UserName=#{UserName},\n" +
            "        UserEmail=#{UserEmail}\n" +
            "        where userId= #{userId}")
    public int update(User user);


    @Delete("delete from user where userId= #{userId}")
    public int delete(String userId);

    @Select("select * from user ")
    public List<User> getAllUser();

    @Select("select * from user where userId= #{userId}")
    public User getUserById(int id);

    @Select("SELECT * FROM user where   UserName like concat('%',#{0},'%')")
    public List<User> getUserByName(String name);


    @Select("SELECT * FROM user where   UserName like concat('%',#{0},'%') and UserEmail like concat ('%',#{1},'%')")
    public List<User> getUserByNameAndEmail(String username, String email);
}
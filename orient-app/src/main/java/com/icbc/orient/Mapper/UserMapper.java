package com.icbc.orient.Mapper;

import com.alibaba.fastjson.JSONObject;
import com.icbc.orient.Bean.JwtUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "role", column = "role"),
           })
    JwtUser loadUserByUsername(String username);

    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "role", column = "role"),
    })
    List<JwtUser> loadAllUser();

    @Delete("Delete from user where username=#{username}")
    Boolean DeleteUser(String username);

    @Update("update user set role=#{role} where username=#{username}")
    Boolean editUserRole(String username,String role);

    @Insert("insert into testDB.user(phone,username,password,role) values(#{phone},#{username},#{password},'user')")
    Integer addUser(String username, String password, String phone);


    @Select("select role from user where username=#{username}")
    String CheckRoleByUsername(String username);







}


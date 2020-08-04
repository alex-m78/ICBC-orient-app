package com.icbc.orient.Service;





import com.alibaba.fastjson.JSONObject;
import com.icbc.orient.Bean.JwtUser;
import com.icbc.orient.Mapper.UserMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtUserService {
    @Autowired(required = false)

    private UserMapper userMapper;


    public JwtUser loadUserByUsername(String username){

        return userMapper.loadUserByUsername(username);
    }


    public List<JwtUser> loadAllUser(){ return userMapper.loadAllUser();};


    public Boolean DeleteUser(String username){return userMapper.DeleteUser(username);};


    public Boolean editUserRole(String username,String role){return userMapper.editUserRole(username,role);};


    public Integer addUser(String username, String password, String phone){return userMapper.addUser(username,password,phone);};

    public String CheckRoleByUsername(String username){return userMapper.CheckRoleByUsername(username);};




}

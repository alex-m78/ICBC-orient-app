package com.icbc.orient.Mapper;

import com.icbc.orient.OrientApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrientApplication.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void loadUserByUsername() {
        userMapper.loadUserByUsername("lihegui");
    }

    @Test
    public void loadAllUser() {
        userMapper.loadAllUser();
    }

    @Test
    public void deleteUser() {
        userMapper.DeleteUser("user");
    }

    @Test
    public void editUserRole() {
        userMapper.editUserRole("user","admin");
    }

    @Test
    public void addUser() {
        userMapper.addUser("user","123456","15888888888");
    }

    @Test
    public void checkRoleByUsername() {
        System.out.println(userMapper.CheckRoleByUsername("username"));
    }
}
package com.icbc.orient.Mapper;

<<<<<<< HEAD
import org.junit.Test;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void loadUserByUsername() {
=======
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
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void loadAllUser() {
<<<<<<< HEAD
=======
        userMapper.loadAllUser();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void deleteUser() {
<<<<<<< HEAD
=======
        userMapper.DeleteUser("user");
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void editUserRole() {
<<<<<<< HEAD
=======
        userMapper.editUserRole("user","admin");
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void addUser() {
<<<<<<< HEAD
=======
        userMapper.addUser("user","123456","15888888888");
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void checkRoleByUsername() {
<<<<<<< HEAD
=======
        System.out.println(userMapper.CheckRoleByUsername("username"));
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }
}
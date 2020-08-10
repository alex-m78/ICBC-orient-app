package com.icbc.orient.Service;

import org.junit.Test;
<<<<<<< HEAD
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtUserServiceTest {

    @Autowired
    JwtUserService jwtUserService;

    @Test
    public void loadUserByUsername() {
        jwtUserService.loadUserByUsername("Zhangyide");
=======

import static org.junit.Assert.*;

public class JwtUserServiceTest {

    @Test
    public void loadUserByUsername() {
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void loadAllUser() {
<<<<<<< HEAD
        jwtUserService.loadAllUser();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void deleteUser() {
<<<<<<< HEAD
        jwtUserService.DeleteUser("user11111");
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void editUserRole() {
<<<<<<< HEAD
        jwtUserService.editUserRole("wangyi","admin");
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void addUser() {
<<<<<<< HEAD
        jwtUserService.addUser("user11111","331331331","1878045288");
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void checkRoleByUsername() {
<<<<<<< HEAD
        jwtUserService.CheckRoleByUsername("user");
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }
}
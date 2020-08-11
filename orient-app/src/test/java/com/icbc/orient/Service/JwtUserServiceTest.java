package com.icbc.orient.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtUserServiceTest {

    @Autowired
    JwtUserService jwtUserService;

    @Test
    public void loadUserByUsername() {
        jwtUserService.loadUserByUsername("Zhangyide");
    }

    @Test
    public void loadAllUser() {
        jwtUserService.loadAllUser();
    }
    @Transactional
    @Rollback
    @Test
    public void deleteUser() {
        jwtUserService.DeleteUser("user");
    }
    @Transactional
    @Rollback
    @Test
    public void editUserRole() {
        jwtUserService.editUserRole("user","admin");
    }
    @Transactional
    @Rollback
    @Test
    public void addUser() {
        jwtUserService.addUser("user","123456","15888888888");
    }

    @Test
    public void checkRoleByUsername() {
        jwtUserService.CheckRoleByUsername("user");
    }
}
package com.icbc.orient.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Transactional
    @Rollback
    @Test
    public void register() throws Exception {
        mockMvc.perform(get("/register?username=Wangyibo9&password=1234567&phone=18264839534")).andDo(print());
    }
    @Transactional
    @Rollback
    @Test
    public void userDelete() throws Exception {
        mockMvc.perform(get("/userDelete?username=user123124")).andDo(print());
    }
    @Transactional
    @Rollback
    @Test
    public void userRole() throws Exception {
        mockMvc.perform(get("/userRole?username=Wangyibo&role=user")).andDo(print());
    }
    @Transactional
    @Rollback
    @Test
    public void userInfo() throws Exception {
        mockMvc.perform(get("/userInfo")).andDo(print());
    }
}
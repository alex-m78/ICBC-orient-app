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
public class TestControllerTest {
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getIndustry() throws Exception {
        mockMvc.perform(get("/industries")).andDo(print());
    }

    @Test
    public void getCar() throws Exception {
        mockMvc.perform(get("/car")).andDo(print());
    }

    @Test
    public void seasonShare() throws Exception {
        mockMvc.perform(get("/seasonShare")).andDo(print());
    }
    @Transactional
    @Rollback
    @Test
    public void feedBack() throws Exception {
        mockMvc.perform(get("/feedBack?msg=Feed back test no")).andDo(print());
    }
}
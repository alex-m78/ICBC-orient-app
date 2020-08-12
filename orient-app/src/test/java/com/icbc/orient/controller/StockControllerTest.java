package com.icbc.orient.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StockControllerTest {
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void getMsg() throws Exception {
        mockMvc.perform(get("/stockHolds")).andDo(print());
    }

//    @Test
//    public void producerTest() {
//    }

    @Test
    public void getModelResultNew() throws Exception {
        mockMvc.perform(get("/kafkaResults?year=2019&quarter=1")).andReturn();
        mockMvc.perform(get("/kafkaResults?year=2019&quarter=2")).andReturn();
       mockMvc.perform(get("/kafkaResults?year=2019&quarter=3")).andReturn();
       mockMvc.perform(get("/kafkaResults?year=2019&quarter=4")).andReturn();
    }

    @Test
    public void getModelResult() throws Exception {
        mockMvc.perform(get("/modelResults?year=2019&quarter=1")).andDo(print());
        mockMvc.perform(get("/modelResults?year=2019&quarter=2")).andDo(print());
        mockMvc.perform(get("/modelResults?year=2019&quarter=3")).andDo(print());
        mockMvc.perform(get("/modelResults?year=2019&quarter=4")).andDo(print());
    }

    @Test
    public void getTarget() throws Exception {
        mockMvc.perform(get("/targetCompared")).andDo(print());
    }

    @Test
    public void getFiveStockInfo() throws Exception {
        mockMvc.perform(get("/fiveStockInfo")).andDo(print());
    }
}
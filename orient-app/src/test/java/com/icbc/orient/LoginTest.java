package com.icbc.orient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author hkd
 * @date 2020/8/11 - 11:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void loginTest() throws Exception {
        mockMvc.perform(get("/login?username=admin&password=123456")).andReturn();
        mockMvc.perform(get("/login?username=lihegui&password=331331")).andDo(print());
        mockMvc.perform(get("/login?username=xxx&password=331331")).andDo(print());
        mockMvc.perform(get("/login?username=lihegui&password=123456")).andDo(print());

        mockMvc.perform(get("/userInfo")).andDo(print());
    }
}

package com.icbc.orient.Filter;

import com.icbc.orient.Filter.JwtLoginFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
//SpringBoot1.4版本之前用的是SpringJUnit4ClassRunner.class
@RunWith(SpringRunner.class)
//SpringBoot1.4版本之前用的是@SpringApplicationConfiguration(classes = Application.class)
@SpringBootTest
//测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的
@WebAppConfiguration
public class JwtLoginFilterTest {
    private JwtLoginFilter jwtLoginFilter=new JwtLoginFilter();
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    //private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter =new UsernamePasswordAuthenticationFilter();

    @Before
    public void setup() {
        // 实例化方式一
        //mockMvc = MockMvcBuilders.standaloneSetup(new JwtLoginFilter()).addFilter(jwtLoginFilter,"/login").build();
        // 实例化方式二
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(jwtLoginFilter).build();
    }

    @Test
    public void attemptAuthentication() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/login")
                .contentType(MediaType.ALL)
                .param("username", "admin")
                .param("password", "123456")
        ) // 断言返回结果是json
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        //拿到请求返回码
        int status = response.getStatus();
        //拿到结果
        String contentAsString = response.getContentAsString();

        System.err.println(status);
        System.err.println(contentAsString);

    }

}




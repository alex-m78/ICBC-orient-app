package com.icbc.orient.Filter;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JwtHeadFilterTest {
    private JwtHeadFilter jwtHeadFilter=new JwtHeadFilter();
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    //private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter =new UsernamePasswordAuthenticationFilter();

    @Test
    public void doFilterInternal() throws ServletException, IOException {
        MockHttpServletRequest request=new MockHttpServletRequest();
        MockHttpServletResponse response=new MockHttpServletResponse();
        FilterChain filterChain=null;
        request.addHeader("Authentication","eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50Tm9uRXhwaXJlZCI6dHJ1ZSwiYWNjb3VudE5vbkxvY2tlZCI6dHJ1ZSwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6ImFkbWluIn1dLCJjcmVkZW50aWFsc05vbkV4cGlyZWQiOnRydWUsImVuYWJsZWQiOnRydWUsImlkIjoxLCJwYXNzd29yZCI6IiQyYSQxMCRrM0ZaUXY1QmUzcEd0OElxUEhyRDVld3NwNS5kR0NvWHlqNkNnMGtBRTNCVUJOL2RTQ1Y5bSIsInBob25lIjoiMTIzNTQ2ODMxMzEiLCJyb2xlIjoiYWRtaW4iLCJ1c2VybmFtZSI6ImFkbWluIn0.QyZCRUrYVEif-0Dz-Q2IgK5SJbtpvn4lIbzmeEZlhgECJMSz1RCdSnVIX2LR0odMMTcI7IRjH-nMpY6L_TuZkatESUCo1Mrq5oBdKTuBPItkdXrt1pLclJSzu5IzetbumxG7aoANh1wAC91flPYb2uEuaUgeEizD950qvE5_pvM");
        jwtHeadFilter.doFilterInternal(request,response,filterChain);
    }

    @Test
    public void doFilterInternal2() throws ServletException, IOException {
        MockHttpServletRequest request=new MockHttpServletRequest();
        MockHttpServletResponse response=new MockHttpServletResponse();
        FilterChain filterChain=null;
        request.addHeader("Authentication","eyJhbGciOiJSUzI1NiIaXJlZCI6dHJ1ZSwiYWNjb3VudE5vbkxvY2tlZCI6dHJ1ZSwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6ImFkbWluIn1dLCJjcmVkZW50aWFsc05vbkV4cGlyZWQiOnRydWUsImVuYWJsZWQiOnRydWUsImlkIjoxLCJwYXNzd29yZCI6IiQyYSQxMCRrM0ZaUXY1QmUzcEd0OElxUEhyRDVld3NwNS5kR0NvWHlqNkNnMGtBRTNCVUJOL2RTQ1Y5bSIsInBob25lIjoiMTIzNTQ2ODMxMzEiLCJyb2xlIjoiYWRtaW4iLCJ1c2VybmFtZSI6ImFkbWluIn0.QyZCRUrYVEif-0Dz-Q2IgK5SJbtpvn4lIbzmeEZlhgECJMSz1RCdSnVIX2LR0odMMTcI7IRjH-nMpY6L_TuZkatESUCo1Mrq5oBdKTuBPItkdXrt1pLclJSzu5IzetbumxG7aoANh1wAC91flPYb2uEuaUgeEizD950qvE5_pvM");
        jwtHeadFilter.doFilterInternal(request,response,filterChain);
    }

}
package com.icbc.orient.security.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginFailureHandlerTest {
     private  LoginFailureHandler loginFailureHandler=new LoginFailureHandler();
    MockHttpServletRequest request=new MockHttpServletRequest();
    MockHttpServletResponse response=new MockHttpServletResponse();

    @Test
    public void onAuthenticationFailure() throws IOException, ServletException {
        loginFailureHandler.onAuthenticationFailure(request,response,null);
    }
}
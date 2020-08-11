package com.icbc.orient.security.simple;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessDecisionServiceTest {

    AccessDecisionService accessDecisionService = new AccessDecisionService();
    @Test
    public void hasPermission() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        request.addParameter("username","admin");
//        request.addParameter("password","123456");
//        JwtLoginToken jwtLoginToken = new JwtLoginToken("admin", "123456");
//        accessDecisionService.hasPermission(request,jwtLoginToken);
    }
    @Test
    public void queryUrlByUserRole() throws Exception {
        Class<AccessDecisionService> access = AccessDecisionService.class;
        AccessDecisionService instance = access.newInstance();
        Method method = access.getDeclaredMethod("queryUrlByUserRole",String.class);
        method.setAccessible(true);
        method.invoke(instance,"admin");

    }
}
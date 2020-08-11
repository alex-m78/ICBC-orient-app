package com.icbc.orient.security.simple;

import com.icbc.orient.Bean.JwtUser;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class JwtAuthenticationProviderTest {

    @Test
    public void authenticate() {
    }

    @Test
    public void supports() {
    }
    @Test
    public void testAdditionalAuthenticationChecks() throws Exception {
        Class<JwtAuthenticationProvider> clazz = JwtAuthenticationProvider.class;
        JwtAuthenticationProvider provider = clazz.newInstance();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123");

        JwtUser user  = new JwtUser();
        user.setUsername("admin");
        user.setPassword("123456");
        Method checks = clazz.getDeclaredMethod("defaultCheck", UserDetails.class);
        checks.setAccessible(true);
        checks.invoke(provider,user);

    }

    @Test
    public void setUserDetailsService() {
    }

    @Test
    public void setPasswordEncoder() {
    }
}
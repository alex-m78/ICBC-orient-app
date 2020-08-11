package com.icbc.orient.security.simple;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ApplicationConfigurerAdapterTest {

    @Test
    public void configure() {
    }

    @Test
    public void passwordEncoder() throws Exception {
        Class<ApplicationConfigurerAdapter> application = ApplicationConfigurerAdapter.class;
        ApplicationConfigurerAdapter configurer = application.newInstance();
        Method passwordEncoder = application.getDeclaredMethod("passwordEncoder");
        passwordEncoder.invoke(configurer);

    }
}
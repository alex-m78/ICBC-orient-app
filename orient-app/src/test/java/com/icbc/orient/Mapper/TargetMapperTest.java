package com.icbc.orient.Mapper;

<<<<<<< HEAD
import org.junit.Test;

import static org.junit.Assert.*;

public class TargetMapperTest {

    @Test
    public void valueTarget() {
=======
import com.icbc.orient.OrientApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrientApplication.class)
public class TargetMapperTest {
    @Autowired
    private TargetMapper targetMapper;
    @Test
    public void valueTarget() {
        targetMapper.ValueTarget();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void profitTarget() {
<<<<<<< HEAD
=======
        targetMapper.ProfitTarget();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void developTarget() {
<<<<<<< HEAD
=======
        targetMapper.DevelopTarget();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void totalTarget() {
<<<<<<< HEAD
=======
        targetMapper.TotalTarget();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void storeFeedback() {
<<<<<<< HEAD
=======
        targetMapper.StoreFeedback("6666");
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }
}
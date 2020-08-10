package com.icbc.orient.Service;


import com.icbc.orient.Bean.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TargetServiceTest {

    @Autowired
    TargetService targetService;

    @Test
    public void totalTarget() {
        targetService.TotalTarget();

    }

    @Test
    public void profitTarget() {

        targetService.ProfitTarget();

    }

    @Test
    public void developTarget() {

        targetService.DevelopTarget();

    }

    @Test
    public void valueTarget() {

        targetService.ValueTarget();

    }

    @Test
    public void storeFeedback() {

        targetService.StoreFeedback("Test if This feature is ok");

    }
}
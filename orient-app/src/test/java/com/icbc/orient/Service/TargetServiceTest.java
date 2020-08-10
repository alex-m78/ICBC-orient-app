package com.icbc.orient.Service;

<<<<<<< HEAD
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

=======
import org.junit.Test;

import static org.junit.Assert.*;

public class TargetServiceTest {

    @Test
    public void totalTarget() {
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void profitTarget() {
<<<<<<< HEAD
        targetService.ProfitTarget();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void developTarget() {
<<<<<<< HEAD
        targetService.DevelopTarget();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void valueTarget() {
<<<<<<< HEAD
        targetService.ValueTarget();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void storeFeedback() {
<<<<<<< HEAD
        targetService.StoreFeedback("Test if This feature is ok");
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }
}
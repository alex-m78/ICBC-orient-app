package com.icbc.orient.Service;


import com.icbc.orient.Bean.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Rollback
    @Test
    public void storeFeedback() {

        targetService.StoreFeedback("Test if This feature is ok","hhh");

    }

    @Test
    public void getFeedBacks() {
        targetService.getFeedBacks();
    }

    @Test
    public void getMetaData() {
        System.out.println(targetService.getMetaData("20190630","平安银行"));
    }
    @Transactional
    @Rollback
    @Test
    public void deleteFeedBack() {
        targetService.deleteFeedBack(322);
    }
}
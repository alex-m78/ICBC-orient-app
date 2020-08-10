package com.icbc.orient.Mapper;

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
    }

    @Test
    public void profitTarget() {
        targetMapper.ProfitTarget();
    }

    @Test
    public void developTarget() {
        targetMapper.DevelopTarget();
    }

    @Test
    public void totalTarget() {
        targetMapper.TotalTarget();
    }

    @Test
    public void storeFeedback() {
        targetMapper.StoreFeedback("6666");
    }
}
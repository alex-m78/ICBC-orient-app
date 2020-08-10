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
public class IndustryMapperTest {
    @Autowired
    private IndustryMapper industryMapper;

    @Test
    public void selectTop5() {
        System.out.println(industryMapper.selectTop5());
    }

    @Test
    public void selectTop10() {
        industryMapper.selectTop10("20180630");
    }

    @Test
    public void getCAR() {
        industryMapper.getCAR();
    }

    @Test
    public void stockPrice1() {
        industryMapper.stockPrice1();
    }

    @Test
    public void stockPrice2() {
        industryMapper.stockPrice2();
    }

    @Test
    public void stockPrice3() {
        industryMapper.stockPrice3();
    }

    @Test
    public void stockPrice4() {
        industryMapper.stockPrice4();
    }

    @Test
    public void stockPrice5() {
        industryMapper.stockPrice5();
    }
}
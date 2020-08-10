package com.icbc.orient.Service;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndustryServiceTest {
    @Autowired
     IndustryService industryService;


    @Test
    public void selectTop5() {
        industryService.selectTop5();
    }

    @Test
    public void selectTop10() {

        industryService.selectTop10("20180331");


    }

    @Test
    public void getCAR() {

        industryService.getCAR();

    }

    @Test
    public void stockPrice1() {

        industryService.stockPrice1();

    }

    @Test
    public void stockPrice2() {

        industryService.stockPrice2();

    }

    @Test
    public void stockPrice3() {

        industryService.stockPrice3();

    }

    @Test
    public void stockPrice4() {

        industryService.stockPrice4();

    }

    @Test
    public void stockPrice5() {

        industryService.stockPrice5();

    }
}
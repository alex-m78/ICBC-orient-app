package com.icbc.orient.Service;

import org.junit.Test;
<<<<<<< HEAD
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
=======

import static org.junit.Assert.*;

public class IndustryServiceTest {

    @Test
    public void selectTop5() {
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void selectTop10() {
<<<<<<< HEAD
        industryService.selectTop10("20180331");

=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void getCAR() {
<<<<<<< HEAD
        industryService.getCAR();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void stockPrice1() {
<<<<<<< HEAD
        industryService.stockPrice1();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void stockPrice2() {
<<<<<<< HEAD
        industryService.stockPrice2();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void stockPrice3() {
<<<<<<< HEAD
        industryService.stockPrice3();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void stockPrice4() {
<<<<<<< HEAD
        industryService.stockPrice4();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void stockPrice5() {
<<<<<<< HEAD
        industryService.stockPrice5();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }
}
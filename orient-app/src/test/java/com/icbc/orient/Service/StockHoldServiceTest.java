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
public class StockHoldServiceTest {

    @Autowired
    StockHoldService stockHoldService;

    @Test
    public void selectTop10() {
        stockHoldService.selectTop10();

    }


    @Test
    public void selectHoldingByYearAndQuater() {
        stockHoldService.selectHoldingByYearAndQuater("20190630");
=======

import static org.junit.Assert.*;

public class StockHoldServiceTest {

    @Test
    public void selectTop10() {
    }

    @Test
    public void selectHolding() {
    }

    @Test
    public void selectHoldInfo() {
    }

    @Test
    public void selectHoldingByYearAndQuater() {
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void selectForNamePre() {
<<<<<<< HEAD
        stockHoldService.selectForNamePre("20190630");
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void selectForNameReal() {
<<<<<<< HEAD
        stockHoldService.selectForNameReal("20190630");
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void selectSeasonshare() {
<<<<<<< HEAD
        stockHoldService.selectSeasonshare();
=======
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }
}
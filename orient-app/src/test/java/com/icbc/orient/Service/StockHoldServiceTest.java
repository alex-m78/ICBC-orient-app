package com.icbc.orient.Service;

import org.junit.Test;
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
    }

    @Test
    public void selectForNamePre() {
        stockHoldService.selectForNamePre("20190630");
    }

    @Test
    public void selectForNameReal() {
        stockHoldService.selectForNameReal("20190630");
    }

    @Test
    public void selectSeasonshare() {
        stockHoldService.selectSeasonshare();
    }
}
package com.icbc.orient.Mapper;

<<<<<<< HEAD
import org.junit.Test;

import static org.junit.Assert.*;

public class StockHoldMapperTest {

    @Test
    public void selectTop10() {
    }

    @Test
    public void selectHolding() {
    }

    @Test
    public void selectStockInfo() {
    }

    @Test
    public void selectForNamePre() {
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
public class StockHoldMapperTest {
    @Autowired
    private StockHoldMapper stockHoldMapper;

    @Test
    public void selectTop10() {
        stockHoldMapper.selectTop10();
    }

//    @Test
//    public void selectHolding() {
//        stockHoldMapper.selectHolding();
//    }

//    @Test
//    public void selectStockInfo() {
//        stockHoldMapper.selectStockInfo();
//    }

    @Test
    public void selectForNamePre() {
        stockHoldMapper.selectForNamePre("20190630");
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void selectForNameReal() {
<<<<<<< HEAD
=======
        stockHoldMapper.selectForNameReal("20190630");
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void selectHoldingByYearAndQuater() {
<<<<<<< HEAD
=======
        stockHoldMapper.selectHoldingByYearAndQuater("20190630");
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void selectSeasonShare() {
<<<<<<< HEAD
=======
        stockHoldMapper.selectSeasonShare();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }
}
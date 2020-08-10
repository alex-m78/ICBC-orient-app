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
    }

    @Test
    public void selectForNameReal() {
        stockHoldMapper.selectForNameReal("20190630");
    }

    @Test
    public void selectHoldingByYearAndQuater() {
        stockHoldMapper.selectHoldingByYearAndQuater("20190630");
    }

    @Test
    public void selectSeasonShare() {
        stockHoldMapper.selectSeasonShare();
    }
}
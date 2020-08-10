package com.icbc.orient.Mapper;

<<<<<<< HEAD
import org.junit.Test;

import static org.junit.Assert.*;

public class IndustryMapperTest {

    @Test
    public void selectTop5() {
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
public class IndustryMapperTest {
    @Autowired
    private IndustryMapper industryMapper;

    @Test
    public void selectTop5() {
        System.out.println(industryMapper.selectTop5());
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void selectTop10() {
<<<<<<< HEAD
=======
        industryMapper.selectTop10("20180630");
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void getCAR() {
<<<<<<< HEAD
=======
        industryMapper.getCAR();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void stockPrice1() {
<<<<<<< HEAD
=======
        industryMapper.stockPrice1();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void stockPrice2() {
<<<<<<< HEAD
=======
        industryMapper.stockPrice2();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void stockPrice3() {
<<<<<<< HEAD
=======
        industryMapper.stockPrice3();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void stockPrice4() {
<<<<<<< HEAD
=======
        industryMapper.stockPrice4();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }

    @Test
    public void stockPrice5() {
<<<<<<< HEAD
=======
        industryMapper.stockPrice5();
>>>>>>> 359a6a7b535020384a3784b1bcc9409a6b13e6d1
    }
}
package com.icbc.orient.Service;

import com.icbc.orient.Bean.CAR;
import com.icbc.orient.Bean.Industry;
import com.icbc.orient.Bean.StockPrice;
import com.icbc.orient.Mapper.IndustryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IndustryService {
    @Autowired
    private IndustryMapper industryMapper;

    public List<Industry> selectTop5(){

    return industryMapper.selectTop5();

    }

    public List<Industry> selectTop10(String date){
        return industryMapper.selectTop10(date);
    }

    public List<CAR> getCAR() {return industryMapper.getCAR();}

    public List<StockPrice> stockPrice1(){return industryMapper.stockPrice1();}
    public List<StockPrice> stockPrice2(){return industryMapper.stockPrice2();}
    public List<StockPrice> stockPrice3(){return industryMapper.stockPrice3();}
    public List<StockPrice> stockPrice4(){return industryMapper.stockPrice4();}
    public List<StockPrice> stockPrice5(){return industryMapper.stockPrice5();}
}

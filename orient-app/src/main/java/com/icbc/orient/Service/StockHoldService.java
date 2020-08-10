package com.icbc.orient.Service;

import com.icbc.orient.Bean.JwtUser;
import com.icbc.orient.Bean.SeasonShare;
import com.icbc.orient.Bean.StockHold;
import com.icbc.orient.Mapper.StockHoldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockHoldService {
    @Autowired
    private StockHoldMapper stockHoldMapper;

    public List<StockHold> selectTop10() {
        return stockHoldMapper.selectTop10();
}

//    public List<StockHold> selectHolding(){ return stockHoldMapper.selectHolding();}

//    public List<StockHold> selectHoldInfo(){ return stockHoldMapper.selectStockInfo();}

    public List<StockHold> selectHoldingByYearAndQuater(String date){
        return stockHoldMapper.selectHoldingByYearAndQuater(date);
    }

    public List<String> selectForNamePre(String date){
        return stockHoldMapper.selectForNamePre(date);
    }

    public List<String> selectForNameReal(String date){
        return stockHoldMapper.selectForNameReal(date);
    }

    public List<SeasonShare> selectSeasonshare(){ return stockHoldMapper.selectSeasonShare(); }

}

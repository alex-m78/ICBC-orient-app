package com.icbc.orient.Mapper;

import com.icbc.orient.Bean.CAR;
import com.icbc.orient.Bean.Industry;
import com.icbc.orient.Bean.StockHold;

import com.icbc.orient.Bean.StockPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface IndustryMapper {
    @Select("SELECT industry,count(industry) as count \n" +
            "FROM testDB.display_prediction \n" +
            "group by industry\n" +
            "order by count\n" +
            "desc limit 0,5;")
    @Results({
            @Result(property = "industryName", column = "industry"),
            @Result(property = "count", column = "count")
    })
    List<Industry> selectTop5();

    /**
     * 功能描述:返回实际重仓股行业数据，只返回前5数据
     * @Param: []
     * @Return: List<Industry>
     * @Author: hkd
     * @Date: 2020/7/24 20:38
     */
    @Select("SELECT d.industry IndustryName,count(*) count\n" +
            "FROM `predicted_and_real_${date}` p\n" +
            "join display_prediction d\n" +
            "on p.ts_code_real = d.ts_code\n" +
            "GROUP BY d.industry\n" +
            "ORDER BY count desc\n" +
            "limit 0,5;\n")
    List<Industry> selectTop10(@Param("date") String date);


    @Select("select * from visualize_CAR_AR")
    @Results({
            @Result(property = "dayCount", column = "id")
    })
    List<CAR> getCAR();

    @Select("select a.ts_code as stockCode,trade_date,close,b.name as stockName\n" +
            "from visualize_top_5 as a,stock_basic as b\n" +
            "where b.ts_code=a.ts_code and a.index=0\n" +
            "order by trade_date desc\n" +
            "limit 0,30;")
    @Results({
            @Result(property = "stockCode", column = "stockCode"),
            @Result(property = "stockName", column = "stockName"),
            @Result(property = "tradeDate", column = "trade_date"),
            @Result(property = "close", column = "close")
    })
    List<StockPrice> stockPrice1();

    @Select("select a.ts_code as stockCode,trade_date,close,b.name as stockName\n" +
            "from visualize_top_5 as a,stock_basic as b\n" +
            "where b.ts_code=a.ts_code and a.index=1\n" +
            "order by trade_date desc\n" +
            "limit 0,30;")
    @Results({
            @Result(property = "stockCode", column = "stockCode"),
            @Result(property = "stockName", column = "stockName"),
            @Result(property = "tradeDate", column = "trade_date"),
            @Result(property = "close", column = "close")
    })
    List<StockPrice> stockPrice2();

    @Select("select a.ts_code as stockCode,trade_date,close,b.name as stockName\n" +
            "from visualize_top_5 as a,stock_basic as b\n" +
            "where b.ts_code=a.ts_code and a.index=2\n" +
            "order by trade_date desc\n" +
            "limit 0,30;")
    @Results({
            @Result(property = "stockCode", column = "stockCode"),
            @Result(property = "stockName", column = "stockName"),
            @Result(property = "tradeDate", column = "trade_date"),
            @Result(property = "close", column = "close")
    })
    List<StockPrice> stockPrice3();

    @Select("select a.ts_code as stockCode,trade_date,close,b.name as stockName\n" +
            "from visualize_top_5 as a,stock_basic as b\n" +
            "where b.ts_code=a.ts_code and a.index=3\n" +
            "order by trade_date desc\n" +
            "limit 0,30;")
    @Results({
            @Result(property = "stockCode", column = "stockCode"),
            @Result(property = "stockName", column = "stockName"),
            @Result(property = "tradeDate", column = "trade_date"),
            @Result(property = "close", column = "close")
    })
    List<StockPrice> stockPrice4();

    @Select("select a.ts_code as stockCode,trade_date,close,b.name as stockName\n" +
            "from visualize_top_5 as a,stock_basic as b\n" +
            "where b.ts_code=a.ts_code and a.index=4\n" +
            "order by trade_date desc\n" +
            "limit 0,30;")
    @Results({
            @Result(property = "stockCode", column = "stockCode"),
            @Result(property = "stockName", column = "stockName"),
            @Result(property = "tradeDate", column = "trade_date"),
            @Result(property = "close", column = "close")
    })
    List<StockPrice> stockPrice5();

}

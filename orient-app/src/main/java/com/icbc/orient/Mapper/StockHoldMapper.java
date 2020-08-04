package com.icbc.orient.Mapper;

import com.icbc.orient.Bean.JwtUser;
import com.icbc.orient.Bean.SeasonShare;
import com.icbc.orient.Bean.StockHold;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface StockHoldMapper {
    @Select("select distinct ts_code,name,count\n" +
            "from stock_basic,holding_20191231\n" +
            "where stock_basic.ts_code=holding_20191231.symbol\n" +
            "order by holding_20191231.count\n" +
            "desc limit 0,10")
    @Results({
            @Result(property = "symbol", column = "ts_code"),
            @Result(property = "stockName", column = "name"),
            @Result(property = "count", column = "count"),
    })
    List<StockHold> selectTop10();

    @Select("select *\n" +
            "from stock_information\n" +
            "order by total_worth\n" +
            "desc limit 0,30")
    @Results({
            @Result(property = "symbol", column = "stock_code"),
            @Result(property = "stockName", column = "stock_name"),
            @Result(property = "count", column = "hold_count"),
            @Result(property = "holdScale", column = "hold_scale"),
            @Result(property = "Compared", column = "compared"),
            @Result(property = "total", column = "car"),
            @Result(property = "totalWorth", column = "total_worth"),
            @Result(property = "netAssert", column = "net_assert"),
            @Result(property = "netProfit", column = "net_profit"),
            @Result(property = "pb", column = "pb"),
            @Result(property = "roe", column = "roe"),
    })
    List<StockHold> selectHolding();//选择展示股票信息

    @Select("select stock_code,stock_name,hold_count,hold_scale,compared,car\n" +
            "from stock_information\n" +
            "order by total_worth\n" +
            "desc limit 0,30")
    @Results({
            @Result(property = "symbol", column = "stock_code"),
            @Result(property = "stockName", column = "stock_name"),
            @Result(property = "count", column = "hold_count"),
            @Result(property = "holdScale", column = "hold_scale"),
            @Result(property = "Compared", column = "compared"),
            @Result(property = "incomeAcc", column = "car"),
    })
    List<StockHold> selectStockInfo();

    /**
     * 功能描述:第二页第三部分展示
     * @Param: []
     * @Return: java.util.List<java.lang.String>
     * @Author: hkd
     * @Date: 2020/7/25 13:28
     */
    @Select("select `股票名称` stockname\n" +
            "from train_data_fillna_1\n" +
            "where end_date = #{date}\n" +
            "order by `总市值(万)_mean` desc\n" +
            "limit 0,30;")
    List<String> selectForName(String date);

    /**
     * 功能描述:第二页第四部分显示
     * @Param: []
     * @Return: java.util.List<com.icbc.orient.Bean.StockHold>
     * @Author: hkd
     * @Date: 2020/7/25 12:38
     */
    @Select("select 股票名称,ts_code,市净率_mean,净资产收益率,市盈率TTM_mean,每股净资产,ROUND(`总市值(万)_mean`,0) as tw\n" +
            "from train_data_fillna_1\n" +
            "where end_date = #{date}\n" +
            "order by `总市值(万)_mean` desc\n" +
            "limit 0,30")
    @Results({
            @Result(property = "stockName",column = "股票名称"),
            @Result(property = "symbol",column = "ts_code"),
            @Result(property = "pb",column = "市净率_mean"),
            @Result(property = "roe",column = "净资产收益率"),
            @Result(property = "pettm",column = "市盈率TTM_mean"),
            @Result(property = "netAssert",column = "每股净资产"),
            @Result(property = "totalWorth",column = "tw")
    })
    List<StockHold> selectHoldingByYearAndQuater(String date);


    @Select("select * from visualize_count")
    @Results({
            @Result(property = "endDate",column = "endDate"),
            @Result(property = "end1",column = "end1"),
            @Result(property = "end2",column = "end2"),
            @Result(property = "end3",column = "end3"),
            @Result(property = "end4",column = "end4"),
            @Result(property = "end5",column = "end5"),
            @Result(property = "end6",column = "end6")
    })
    List<SeasonShare> selectSeasonShare();



}

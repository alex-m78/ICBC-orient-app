package com.icbc.orient.Mapper;

import com.icbc.orient.Bean.Industry;
import com.icbc.orient.Bean.Target;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TargetMapper {
    /*@Select("SELECT IndexType,mean,SD,validSample FROM Target\n" +
            "where StockType='heavyStock'")
    List<Target> loadHeavyTarget();

    @Select("SELECT IndexType,mean,SD,validSample FROM Target\n" +
            "where StockType='nonHeavyStock'")
    List<Target> loadNonHeavyTarget(); */


    @Select("SELECT * FROM testDB.contrast_3\n" +
            "where feature='市盈率TTM' or feature='市净率';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0")
    })
    List<Target> ValueTarget();

    @Select("SELECT * FROM testDB.contrast_3\n" +
            "where feature='营业收入' or feature='每股收益' or feature='净资产收益率' or feature='总资产净利润率';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0")
    })
    List<Target> ProfitTarget();

    @Select("SELECT * FROM testDB.contrast_3\n" +
            "where feature='净资产同比增长率' or feature='净利润同比增长率' or feature='营业收入同比增长率';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0")
    })
    List<Target> DevelopTarget();

    @Select("SELECT * FROM testDB.contrast_3\n" +
            "where feature='总市值(万)';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0")
    })
    List<Target> TotalTarget();



    @Insert("insert into testDB.FeedBack(feedBack) values(#{msg})")
    Boolean StoreFeedback(String msg);




}

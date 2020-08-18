package com.icbc.orient.Mapper;

import com.icbc.orient.Bean.FeedBack;
import com.icbc.orient.Bean.Industry;
import com.icbc.orient.Bean.MetaData;
import com.icbc.orient.Bean.Target;
import org.apache.ibatis.annotations.*;
import org.apache.kafka.common.protocol.types.Field;

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
            "where feature='股息率TTM' or feature='季最大跌幅' or feature='月涨跌幅(复权)_0' or feature='月涨跌幅(复权)_1' or feature='月涨跌幅(复权)_2' or feature='季最低价';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0"),
            @Result(property = "corr",column = "corr")
    })
    List<Target> ValueTarget();

    @Select("SELECT * FROM testDB.contrast_3\n" +
            "where feature='利润总额' or feature='每股营业收入' or feature='每股收益(单季度)' or feature='净资产收益率(单季度)' or feature='总资产净利率(杜邦分析)';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0"),
            @Result(property = "corr",column = "corr")
    })
    List<Target> ProfitTarget();

    @Select("SELECT * FROM testDB.contrast_3\n" +
            "where feature='流动资产周转率' or feature='总资产周转率';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0"),
            @Result(property = "corr",column = "corr")
    })
    List<Target> OperationTarget();

    @Select("SELECT * FROM testDB.contrast_3\n" +
            "where feature='每股净资产' or feature='每股未分配利润' or feature='每股资本公积';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0"),
            @Result(property = "corr",column = "corr")
    })
    List<Target> DevelopTarget();

    @Select("SELECT * FROM testDB.contrast_3\n" +
            "where feature='总市值(万)' or feature='流通市值(万)';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0"),
            @Result(property = "corr",column = "corr")
    })
    List<Target> TotalTarget();

    @Select("SELECT * FROM testDB.contrast_3\n" +
            "where feature='每股现金流';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0"),
            @Result(property = "corr",column = "corr")
    })
    List<Target> CashTarget();

    @Select("SELECT * FROM testDB.contrast_3\n" +
            "where feature='所得税' or feature='所得税/利润总额';")
    @Results({
            @Result(property = "feature",column = "feature"),
            @Result(property = "target",column = "target"),
            @Result(property = "mean1",column = "mean_1"),
            @Result(property = "std1",column = "std_1"),
            @Result(property = "len1",column = "len_1"),
            @Result(property = "mean2",column = "mean_0"),
            @Result(property = "std2",column = "std_0"),
            @Result(property = "len2",column = "len_0"),
            @Result(property = "corr",column = "corr")
    })
    List<Target> TaxTarget();



    @Insert("insert into testDB.FeedBack(feedBack,name) values(#{msg},#{name})")
    Boolean StoreFeedback(@Param("msg") String msg,@Param("name")String name);

    @Select("SELECT * FROM `FeedBack`")
    List<FeedBack> getFeedBack();

    @Delete("DELETE from FeedBack\n" +
            "where idnew_table = #{id}")
    void deleteFeedBack(long id);


    @Select("SELECT * \n" +
            "FROM `train_data_3`\n" +
            "where end_date = #{date}\n" +
            "and name = #{name}")
    MetaData getMetaData(@Param("date") String date,@Param("name") String name);
}

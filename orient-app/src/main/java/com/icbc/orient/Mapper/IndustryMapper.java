package com.icbc.orient.Mapper;

import com.icbc.orient.Bean.Industry;
import com.icbc.orient.Bean.StockHold;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IndustryMapper {
    @Select("SELECT * FROM IndustryInfo\n" +
            "order by count\n" +
            "desc limit 0,5")
    @Results({
            @Result(property = "industryName", column = "industryName"),
            @Result(property = "count", column = "count")
    })
    List<Industry> selectTop5();

    /**
     * 功能描述:返回实际重仓股行业数据，只返回前十数据
     * @Param: []
     * @Return: List<Industry>
     * @Author: hkd
     * @Date: 2020/7/24 20:38
     */
    @Select("select `所属行业` industryName,count(*) as count\n" +
            "from train_data_fillna_1\n" +
            "where end_date = #{date}\n" +
            "GROUP BY `所属行业`\n" +
            "ORDER BY count DESC\n" +
            "limit 0,10;")
    List<Industry> selectTop10(String date);
}

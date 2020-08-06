package com.icbc.orient.Mapper;

import com.icbc.orient.Bean.CAR;
import com.icbc.orient.Bean.Industry;
import com.icbc.orient.Bean.StockHold;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
     * 功能描述:返回实际重仓股行业数据，只返回前十数据
     * @Param: []
     * @Return: List<Industry>
     * @Author: hkd
     * @Date: 2020/7/24 20:38
     */
    @Select("select industry industryName,count(*) as count\n" +
            "from train_data_fillna_3\n" +
            "where end_date = #{date}\n" +
            "GROUP BY industry\n" +
            "ORDER BY count DESC\n" +
            "limit 0,10;")
    List<Industry> selectTop10(String date);


    @Select("select * from visualize_CAR_AR")
    @Results({
            @Result(property = "dayCount", column = "id")
    })
    List<CAR> getCAR();
}

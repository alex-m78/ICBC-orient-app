package com.icbc.orient.Mapper;

import com.icbc.orient.Bean.CAR;
import com.icbc.orient.Bean.Industry;
import com.icbc.orient.Bean.StockHold;
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
}

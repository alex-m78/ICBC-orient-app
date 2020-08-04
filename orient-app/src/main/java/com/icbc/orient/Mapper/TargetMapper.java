package com.icbc.orient.Mapper;

import com.icbc.orient.Bean.Industry;
import com.icbc.orient.Bean.Target;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TargetMapper {
    @Select("SELECT IndexType,mean,SD,validSample FROM Target\n" +
            "where StockType='heavyStock'")
    List<Target> loadHeavyTarget();

    @Select("SELECT IndexType,mean,SD,validSample FROM Target\n" +
            "where StockType='nonHeavyStock'")
    List<Target> loadNonHeavyTarget();

    @Insert("insert into testDB.FeedBack(feedBack) values(#{msg})")
    Boolean StoreFeedback(String msg);


}

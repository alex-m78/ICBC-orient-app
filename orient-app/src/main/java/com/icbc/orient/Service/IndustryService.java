package com.icbc.orient.Service;

import com.icbc.orient.Bean.Industry;
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
}

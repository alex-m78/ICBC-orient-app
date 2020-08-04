package com.icbc.orient.Service;

import com.icbc.orient.Bean.Target;
import com.icbc.orient.Mapper.TargetMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetService {
    @Autowired

    public TargetMapper targetMapper;

    public List<Target> loadHeavyTarget(){return targetMapper.loadHeavyTarget();};

    public List<Target> loadNonHeavyTarget(){return targetMapper.loadNonHeavyTarget();};


    public boolean StoreFeedback(String msg){return targetMapper.StoreFeedback(msg);};
}

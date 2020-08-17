package com.icbc.orient.Service;

import com.icbc.orient.Bean.FeedBack;
import com.icbc.orient.Bean.MetaData;
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
    /*
    public List<Target> loadHeavyTarget(){return targetMapper.loadHeavyTarget();};

    public List<Target> loadNonHeavyTarget(){return targetMapper.loadNonHeavyTarget();};
    */

    public List<Target> TotalTarget(){return targetMapper.TotalTarget();};
    public List<Target> ProfitTarget(){return targetMapper.ProfitTarget();};
    public List<Target> DevelopTarget(){return targetMapper.DevelopTarget();};
    public List<Target> ValueTarget(){return targetMapper.ValueTarget();};

    public boolean StoreFeedback(String msg,String name){return targetMapper.StoreFeedback(msg,name);};

    public List<FeedBack> getFeedBacks(){
        return  targetMapper.getFeedBack();
    }

    public MetaData getMetaData(String date,String name){
        return targetMapper.getMetaData(date,name);
    }
}

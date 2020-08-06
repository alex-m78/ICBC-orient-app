package com.icbc.orient.controller;

import com.alibaba.fastjson.JSONObject;
import com.icbc.orient.Bean.*;
import com.icbc.orient.Service.IndustryService;
import com.icbc.orient.Service.StockHoldService;
import com.icbc.orient.Service.TargetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
public class StockController {

    @Autowired
    private StockHoldService SHSer;
    private TargetService TSer;
    private IndustryService inSer;

    /**任何人都能访问
     * @return
     * @param shSer
     * @param tSer
     * @param inSer
     */
    /* */
    public StockController(StockHoldService shSer, TargetService tSer, IndustryService inSer) {
        SHSer = shSer;
        TSer = tSer;
        this.inSer = inSer;
    }

    @ApiOperation("基金持有数柱状图")
    @GetMapping("/stockHolds")
    public ReturnType getMsg(){
        ReturnType rt=new ReturnType();
        rt.setCode("200");
        rt.setMsg("返回成功");
        rt.setSuccess(true);
        rt.setResult(SHSer.selectTop10());
        return rt;

    }

    @ApiOperation("预测对比表格接口")
    @GetMapping("/modelResults")
    public ReturnType getModelResult(int year,int quarter){
        Map<String,Object> lists  = new HashMap<>();
        ArrayList<Industry> industryDataReal = new ArrayList<Industry>();
        switch (quarter){
            case 2 : {
                //第二页第一部分数据
                List<Industry> industryDataPre = inSer.selectTop10("20160630");
                lists.put("industryDataPre",industryDataPre);
                //第二页第二部分数据
                industryDataReal = (ArrayList)inSer.selectTop10(year + "0630");
                lists.put("industryDataReal",industryDataReal);
                //第二页第三部分数据
                List<String> compareStockData = SHSer.selectForNamePre(year + "0630");
                lists.put("predictStock",compareStockData);
                List<String> stringList = SHSer.selectForNameReal(year + "0630");
                lists.put("realStock",stringList);
                //第二页第四部分数据
                ArrayList arrayList = (ArrayList) SHSer.selectHoldingByYearAndQuater(year + "0630");
                lists.put("stockDataDetail",arrayList);

                ReturnType rt = new ReturnType();
                rt.setCode("200");
                rt.setMsg("返回成功");
                rt.setSuccess(true);
                rt.setResult(lists);
                return rt;
            }
            case 3 : {
                //第二页第一部分数据
                List<Industry> industryDataPre = inSer.selectTop10("20160630");
                lists.put("industryDataPre",industryDataPre);
                //第二页第二部分数据
                industryDataReal = (ArrayList)inSer.selectTop10(year + "0930");
                lists.put("industryDataReal",industryDataReal);
                //第二页第三部分数据
                List<String> compareStockData = SHSer.selectForNamePre("20160630");
                lists.put("predictStock",compareStockData);
                List<String> stringList = SHSer.selectForNameReal(year + "0930");
                lists.put("realStock",stringList);
                //第二页第四部分数据
                ArrayList arrayList = (ArrayList) SHSer.selectHoldingByYearAndQuater(year + "0930");
                lists.put("stockDataDetail",arrayList);

                ReturnType rt=new ReturnType();
                rt.setCode("200");
                rt.setMsg("返回成功");
                rt.setSuccess(true);
                rt.setResult(lists);
                return rt;
            }
            case 4 : {
                //第二页第一部分数据
                List<Industry> industryDataPre = inSer.selectTop10("20160630");
                lists.put("industryDataPre",industryDataPre);
                //第二页第二部分数据
                industryDataReal = (ArrayList)inSer.selectTop10(year + "1231");
                lists.put("industryDataReal",industryDataReal);
                //第二页第三部分数据
                List<String> compareStockData = SHSer.selectForNamePre("20160630");
                lists.put("predictStock",compareStockData);
                List<String> stringList = SHSer.selectForNameReal(year + "1231");
                lists.put("realStock",stringList);
                //第二页第四部分数据
                ArrayList arrayList = (ArrayList) SHSer.selectHoldingByYearAndQuater(year + "1231");
                lists.put("stockDataDetail",arrayList);
                ReturnType rt=new ReturnType();
                rt.setCode("200");
                rt.setMsg("返回成功");
                rt.setSuccess(true);
                rt.setResult(lists);
                return rt;
            }
            default:{
                ReturnType rt=new ReturnType();
                rt.setCode("421");
                rt.setMsg("数据库没有该数据");
                rt.setSuccess(true);
                rt.setResult(null);
                return rt;
            }
        }

    }

    @ApiOperation("列表")
    @GetMapping("/targetCompared")
    public ReturnType getTarget(){


        JSONObject object1=new JSONObject();
        List<Target> TotalTarget=TSer.TotalTarget();
        List<Target> DevelopTarget=TSer.DevelopTarget();
        List<Target> ValueTarget=TSer.ValueTarget();
        List<Target> ProfitTarget=TSer.ProfitTarget();

        for(int i=0;i<1;i++)
        {
            Target targets=TotalTarget.get(i);
            targets.setTarget("公司规模");
        }
        for(int i=0;i<3;i++)
        {
            Target targets=DevelopTarget.get(i);
            targets.setTarget("发展能力");
        }
        for(int i=0;i<2;i++)
        {
            Target targets=ValueTarget.get(i);
            targets.setTarget("价值比率");
        }
        for(int i=0;i<4;i++)
        {
            Target targets=ProfitTarget.get(i);
            targets.setTarget("盈利能力");
        }




        List<Object> result =Arrays.asList(TotalTarget,DevelopTarget,ValueTarget,ProfitTarget);


        ReturnType rt=new ReturnType();
        rt.setCode("200");
        rt.setMsg("返回成功");
        rt.setSuccess(true);
        rt.setResult(result);
        return rt;

    }

    @ApiOperation("预测的五个重仓股股价变化图（五个小框）")
    @GetMapping("/fiveStockInfo")
    public ReturnType getFiveStockInfo(){

        List<StockPrice> list1=inSer.stockPrice1();
        List<StockPrice> list2=inSer.stockPrice2();
        List<StockPrice> list3=inSer.stockPrice3();
        List<StockPrice> list4=inSer.stockPrice4();
        List<StockPrice> list5=inSer.stockPrice5();
        List<Object> result =Arrays.asList(list1,list2,list3,list4,list5);
        /*JSONObject jsonObject = new JSONObject();
        List<Double> list1  = Arrays.asList(1500.0,1600.0,1700.0,1660.0,1800.0);
        jsonObject.put("stockOne",new StockPrice("贵州茅台",list1));
        List<Double> list2  = Arrays.asList(180.0,190.0,200.0,160.0,1800.0);
        jsonObject.put("stockTwo",new StockPrice("泸州老窖",list2));
        List<Double> list3  = Arrays.asList(8.0,8.5,9.0,8.9,9.6);
        jsonObject.put("stockThree",new StockPrice("宗申动力",list3));
        List<Double> list4  = Arrays.asList(10.4,9.8,9.9,9.98,10.22);
        jsonObject.put("stockFour",new StockPrice("炬华科技",list4));
        List<Double> list5  = Arrays.asList(13.97,13.82,13.48,13.70,13.71);
        jsonObject.put("stockFive",new StockPrice("浙江美大",list5)); */

        ReturnType rt=new ReturnType();
        rt.setCode("200");
        rt.setMsg("返回成功");
        rt.setSuccess(true);
        rt.setResult(result);
        return rt;
    }
}

package com.icbc.orient.controller;

import com.alibaba.fastjson.JSONObject;
import com.icbc.orient.Bean.*;
import com.icbc.orient.Service.IndustryService;
import com.icbc.orient.Service.StockHoldService;
import com.icbc.orient.Service.TargetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
        object1.put("target","发展能力");
        List<String> subTarget = Arrays.asList("总资产增长率","净利润增长率","营业收入增长率");
        object1.put("subTarget",subTarget);
        object1.put("meanT","22.9%");
        object1.put("type","");
        List<Target> heavyStock = TSer.loadHeavyTarget();
        List<Target> nonHeavyStock = TSer.loadNonHeavyTarget();
        object1.put("heavyStock",heavyStock);
        object1.put("nonHeavyStock",nonHeavyStock);
        List<Object> result =Arrays.asList(object1,object1);
        //List<Object> lists  = new ArrayList<>();
        //lists.add(object1);
        //Map<String,Object> map1=new HashMap<>();
        //Map<String,Object> map2=new HashMap<>();


        //map1.put("heavyStock",heavyStock);
        //lists.add(map1);


        //lists.add(map2);
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
        JSONObject jsonObject = new JSONObject();
        List<Double> list1  = Arrays.asList(1500.0,1600.0,1700.0,1660.0,1800.0);
        jsonObject.put("stockOne",new StockPrice("贵州茅台",list1));
        List<Double> list2  = Arrays.asList(180.0,190.0,200.0,160.0,1800.0);
        jsonObject.put("stockTwo",new StockPrice("泸州老窖",list2));
        List<Double> list3  = Arrays.asList(8.0,8.5,9.0,8.9,9.6);
        jsonObject.put("stockThree",new StockPrice("宗申动力",list3));
        List<Double> list4  = Arrays.asList(10.4,9.8,9.9,9.98,10.22);
        jsonObject.put("stockFour",new StockPrice("炬华科技",list4));
        List<Double> list5  = Arrays.asList(13.97,13.82,13.48,13.70,13.71);
        jsonObject.put("stockFive",new StockPrice("浙江美大",list5));
        ReturnType rt=new ReturnType();
        rt.setCode("200");
        rt.setMsg("返回成功");
        rt.setSuccess(true);
        rt.setResult(jsonObject);
        return rt;
    }
}

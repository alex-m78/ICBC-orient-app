package com.icbc.orient.controller;

import com.icbc.orient.Bean.*;
import com.icbc.orient.Service.IndustryService;
import com.icbc.orient.Service.JwtUserService;
import com.icbc.orient.Service.StockHoldService;
import com.icbc.orient.Service.TargetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// import org.apache.kafka.clients.producer.KafkaProducer;
// import org.apache.kafka.clients.producer.ProducerConfig;
// import org.apache.kafka.clients.producer.ProducerRecord;

// import org.apache.kafka.clients.consumer.ConsumerRecord;
// import org.apache.kafka.clients.consumer.ConsumerRecords;
// import org.apache.kafka.clients.consumer.KafkaConsumer;

// import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private JwtUserService userSer;
    private IndustryService inSer;
    private StockHoldService stockHoldService;
    private TargetService targetService;

//    @Autowired
//    private KafkaTemplate<Object, Object> template;

    /**
     * 任何人都能访问
     *
     * @return
     * @param inSer
     * @param stockHoldService
     * @param targetService
     */

    public TestController(IndustryService inSer, StockHoldService stockHoldService, TargetService targetService) {
        this.inSer = inSer;
        this.stockHoldService = stockHoldService;
        this.targetService = targetService;

    }

    @ApiOperation("饼状图（上一季度新进重仓股排行前五行业）")
    @GetMapping("/industries")
    public ReturnType getIndustry() {
        List<Industry> industryList = new ArrayList<Industry>(5);

        industryList = inSer.select();

        ReturnType rt = new ReturnType();
        rt.setCode("200");
        rt.setMsg("返回成功");
        rt.setSuccess(true);
        rt.setResult(industryList);

        return rt;

    }

    @ApiOperation("重仓股超额收益率图")
    @GetMapping("/car")
    public ReturnType getCar() {

        ReturnType rt = new ReturnType();
        List<CAR> result = inSer.getCAR();
        rt.setCode("200");
        rt.setMsg("返回成功");
        rt.setSuccess(true);
        rt.setResult(result);
        return rt;


    }


//
//    @ApiOperation("kafka生产者测试")
//    @GetMapping("/producerTest")
//    public String producerTest() {
//
//        System.out.println("i'm in producer");
//
//        this.template.send("topic_rec", "20190331");
//        return "msg sent";
//    }

//    @ApiOperation("kafka消费者测试")
//    @GetMapping("/consumerTest")
//    @KafkaListener(topics = {"topic002"})
//    public String consumerTest(ConsumerRecord<String, String> record) {
//
//        System.out.println("i'm in consumer");
//        System.out.println(record);
//        return "msg recived";
//
//    }

    @ApiOperation("首页占比图")
    @GetMapping("/seasonShare")
    public ReturnType SeasonShare() {

        ReturnType rt = new ReturnType();
        rt.setCode("200");
        rt.setMsg("返回成功");
        rt.setSuccess(true);
        List<SeasonShare> result = stockHoldService.selectSeasonshare();
        rt.setResult(result);

        return rt;

    }

    @ApiOperation("用户意见反馈")
    @GetMapping("/feedBack")
    public ReturnType FeedBack(@ApiParam("前端发来的用户反馈，进行储存")String msg,String name) {

        ReturnType rt = new ReturnType();
        rt.setResult(null);
        boolean result=targetService.StoreFeedback(msg,name);
        if(result){
            rt.setCode("200");
            rt.setMsg("意见反馈成功");
            rt.setSuccess(true);
        }else{
            rt.setCode("500");
            rt.setMsg("意见反馈失败，请重试");
            rt.setSuccess(false);
        }
        return rt;

    }
    @ApiOperation("获取所有的反馈")
    @GetMapping("/feedBacks")
    public List<FeedBack> feedBack(){
        List<FeedBack> list = new ArrayList<>();
        list = targetService.getFeedBacks();
        return list;
    }
    @ApiOperation("根据id删除反馈")
    @DeleteMapping("/feedBack")
    public void deleteFeedBack(long id){
        targetService.deleteFeedBack(id);
    }

    @ApiOperation("获取原始数据")
    @GetMapping("/metaData")
    public ReturnType getMetaData(String year,int quarter,String name){
        switch (quarter){
            case 2:
            {
                MetaData metaData = targetService.getMetaData(year + "0630", name);
                ReturnType rt = new ReturnType();
                rt.setCode("200");
                rt.setMsg("请求成功");
                rt.setSuccess(true);
                rt.setResult(metaData);
                return rt;
            }
            case 3:
            {
                MetaData metaData = targetService.getMetaData(year + "0930", name);
                ReturnType rt = new ReturnType();
                rt.setCode("200");
                rt.setMsg("请求成功");
                rt.setSuccess(true);
                rt.setResult(metaData);
                return rt;
            }
            case 4:
            {
                MetaData metaData = targetService.getMetaData(year + "1231", name);
                ReturnType rt = new ReturnType();
                rt.setCode("200");
                rt.setMsg("请求成功");
                rt.setSuccess(true);
                rt.setResult(metaData);
                return rt;
            }
            case 1:
            {
                MetaData metaData = targetService.getMetaData(year + "0331", name);
                ReturnType rt = new ReturnType();
                rt.setCode("200");
                rt.setMsg("请求成功");
                rt.setSuccess(true);
                rt.setResult(metaData);
                return rt;
            }
            default:{
                ReturnType rt = new ReturnType();
                rt.setCode("421");
                rt.setMsg("没有该数据");
                rt.setSuccess(true);
                rt.setResult(null);
                return rt;
            }
        }
    }
}


package com.icbc.orient.controller;

import com.icbc.orient.Bean.*;
import com.icbc.orient.Service.IndustryService;
import com.icbc.orient.Service.JwtUserService;
import com.icbc.orient.Service.StockHoldService;
import com.icbc.orient.Service.TargetService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private KafkaTemplate<Object, Object> template;

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

        industryList = inSer.selectTop5();

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
        List<CAR> carList = new ArrayList<CAR>(121);
        ReturnType rt = new ReturnType();
        for (int i = 0; i < 121; i++) {
            CAR car = new CAR(i - 60, 0.5f, 0.1f);
            carList.add(car);

        }
        rt.setCode("200");
        rt.setMsg("返回成功");
        rt.setSuccess(true);
        rt.setResult(carList);
        return rt;


    }



    @ApiOperation("kafka生产者测试")
    @GetMapping("/producerTest")
    public String producerTest() {

        System.out.println("i'm in producer");

        this.template.send("topic002", "this is a kafka msg !");
        return "msg sent";
    }

    @ApiOperation("kafka消费者测试")
    @GetMapping("/consumerTest")
    @KafkaListener(topics = {"topic002"})
    public String consumerTest(ConsumerRecord<String, String> record) {

        System.out.println("i'm in consumer");
        System.out.println(record);
        return "msg recived";

    }

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
    public ReturnType FeedBack(@ApiParam("前端发来的用户反馈，进行储存")String msg) {

        ReturnType rt = new ReturnType();
        rt.setResult(null);
        boolean result=targetService.StoreFeedback(msg);
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

}


package com.icbc.orient.controller;

import com.alibaba.fastjson.JSONObject;
import com.icbc.orient.Bean.*;
import com.icbc.orient.Service.IndustryService;
import com.icbc.orient.Service.StockHoldService;
import com.icbc.orient.Service.TargetService;
import io.swagger.annotations.ApiOperation;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
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
    @Autowired
    private KafkaTemplate<Object, Object> template;

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

    @ApiOperation("kafka测试")
    @GetMapping("/kafkaTest1")
    public void producerTest() {
        Properties prop = new Properties();
        prop.put("bootstrap.servers", "47.103.137.116:9092");//kafka集群，broker-list
        prop.put("acks", "all");
        prop.put("retries", 1);//重试次数
        prop.put("batch.size", 16384);//批次大小
        prop.put("linger.ms", 1);//等待时间
        prop.put("buffer.memory", 33554432);//RecordAccumulator缓冲区大小
        prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(prop);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String, String>("first", Integer.toString(i), Integer.toString(i)), new Callback() {

                //回调函数，该方法会在Producer收到ack时调用，为异步调用
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception == null) {
                        System.out.println("success->" + metadata.offset());
                    } else {
                        exception.printStackTrace();
                    }
                }
            });
        }
        producer.close();
/////////////////////////////////////////////////////////////////////////////////////
        Properties props = new Properties();
        props.put("bootstrap.servers", "47.103.137.116:9092");
        props.put("group.id", "test");//消费者组，只要group.id相同，就属于同一个消费者组
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("first"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
    }


    @ApiOperation("实时计算预测结果")
    @GetMapping("/newModelResults")
    public ReturnType getModelResultNew(int year,int quarter){
        Map<String,Object> map = new HashMap<>();
        switch (quarter){
            case 2: {
                //第一部分，预测的重仓股行业数据
//                template.send("topic_rec", "20190331");
                //第二部分，实际重仓股行业数据
                ArrayList<Industry> industryDataReal = (ArrayList)inSer.selectTop10(year + "0331");
                map.put("industryDataReal",industryDataReal);
                //第三部分 对比预测和实际的重仓股名称
                List<String> compareStockData = SHSer.selectForNamePre(year + "0331");
                map.put("predictStock",compareStockData);
                List<String> stringList = SHSer.selectForNameReal(year + "0331");
                map.put("realStock",stringList);
                //第四部分 预测重仓股详细信息
//                template.send("topic_rec", "20190331");
                template.send("topic_hkd", "20190331");
//                consumerTest()

                ReturnType rt = new ReturnType();
                rt.setCode("200");
                rt.setMsg("返回成功");
                rt.setSuccess(true);
                rt.setResult(map);
                return rt;
            }
            case 3:{

            }
            case 4:{

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

    @ApiOperation("从数据库读预测对比表格接口的数据")
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

        /*JSONObject object1=new JSONObject();
        object1.put("target","发展能力");
        List<String> subTarget = Arrays.asList("总资产增长率","净利润增长率","营业收入增长率");
        object1.put("subTarget",subTarget);
        object1.put("meanT","22.9%");
        object1.put("type","");
        List<Target> heavyStock = TSer.loadHeavyTarget();
        List<Target> nonHeavyStock = TSer.loadNonHeavyTarget();
        object1.put("heavyStock",heavyStock);
        object1.put("nonHeavyStock",nonHeavyStock);
        List<Object> result =Arrays.asList(object1,object1);*/

        JSONObject object1=new JSONObject();
        List<Target> TotalTarget=TSer.TotalTarget();
        //object1.put("公司规模",TotalTarget);
        List<Target> DevelopTarget=TSer.DevelopTarget();
        //object1.put("发展能力",DevelopTarget);
        List<Target> ValueTarget=TSer.ValueTarget();
        //object1.put("价值比率",ValueTarget);
        List<Target> ProfitTarget=TSer.ProfitTarget();
        //object1.put("盈利能力",ProfitTarget);
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

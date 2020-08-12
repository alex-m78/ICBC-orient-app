package com.icbc.orient.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.icbc.orient.Bean.*;
import com.icbc.orient.Service.IndustryService;
import com.icbc.orient.Service.StockHoldService;
import com.icbc.orient.Service.TargetService;
import io.swagger.annotations.ApiOperation;
import org.apache.kafka.clients.consumer.ConsumerConfig;
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

import java.time.Duration;
import java.util.*;


@RestController
public class StockController {

    @Autowired
    private StockHoldService SHSer;
    private TargetService TSer;
    private IndustryService inSer;
//    @Autowired
//    private KafkaTemplate<Object, Object> template;

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
//    @ApiOperation("kafka测试")
//    @GetMapping("/kafkaTest1")
//    public void producerTest() {
//        Properties prop = new Properties();
//        prop.put("bootstrap.servers", "47.103.137.116:9092");//kafka集群，broker-list
//        prop.put("acks", "all");
//        prop.put("retries", 1);//重试次数
//        prop.put("batch.size", 16384);//批次大小
//        prop.put("linger.ms", 1);//等待时间
//        prop.put("buffer.memory", 33554432);//RecordAccumulator缓冲区大小
//        prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        Producer<String, String> producer = new KafkaProducer<>(prop);
//        for (int i = 0; i < 100; i++) {
//            producer.send(new ProducerRecord<String, String>("first", Integer.toString(i), Integer.toString(i)), new Callback() {
//
//                //回调函数，该方法会在Producer收到ack时调用，为异步调用
//                @Override
//                public void onCompletion(RecordMetadata metadata, Exception exception) {
//                    if (exception == null) {
//                        System.out.println("kafka数据发送成功");
//                    } else {
//                        System.out.println("kafka数据发送失败");
//                        exception.printStackTrace();
//                    }
//                }
//            });
//        }
//        producer.close();
///////////////////////////////////////////////////////////////////////////////////////
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "47.103.137.116:9092");
//        props.put("group.id", "test");//消费者组，只要group.id相同，就属于同一个消费者组
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(Arrays.asList("first"));
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//            }
//        }
//    }


    @ApiOperation("实时计算预测结果")
    @GetMapping("/kafkaResults")
    public ReturnType getModelResultNew(int year,int quarter) {
        Map<String, Object> map = new HashMap<>();
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

        Properties props = new Properties();
        props.put("bootstrap.servers", "47.103.137.116:9092");
        props.put("group.id", "test");//消费者组，只要group.id相同，就属于同一个消费者组
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG,"600000");
//        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG,"15000");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("topic_send2"));

        switch (quarter) {
            case 2: {
                //producer发送
                producer.send(new ProducerRecord<String, String>("topic_rec2", "endDate", year + "0331"), new Callback() {

                    //回调函数，该方法会在Producer收到ack时调用，为异步调用
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception == null) {
                            System.out.println("kafka数据发送成功");
                        } else {
                            System.out.println("kafka数据发送失败");
                            exception.printStackTrace();
                        }
                    }
                });
                producer.close();

                boolean flag = false;
                String list4 = null;
//                long startTime = System.currentTimeMillis();
                // consumer接收
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                    for (ConsumerRecord<String, String> record : records) {
                        list4 = record.value();
//                        long endTime = System.currentTimeMillis();
//                        System.out.println(record.value());json字符串java写法
//                        if(endTime - startTime > 1000) list4 = "{\'error\': 'timeout'}";
                        if (list4 != null) {
                            break;
                        }
                    }
                    System.out.println("kafka接受到数据: " + list4);
                    if (list4 != null) break;
                }
                JSONObject jsonObject = JSON.parseObject(list4);

                ReturnType rt = new ReturnType();
                rt.setCode("200");
                rt.setMsg("返回成功");
                rt.setSuccess(true);
                rt.setResult(jsonObject);
                return rt;
            }
            case 3: {
                //producer发送
                producer.send(new ProducerRecord<String, String>("topic_rec2", "endDate", year + "0630"), new Callback() {

                    //回调函数，该方法会在Producer收到ack时调用，为异步调用
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception == null) {
                            System.out.println("kafka数据发送成功");
                        } else {
                            System.out.println("kafka数据发送失败");
                            exception.printStackTrace();
                        }
                    }
                });
                producer.close();

                boolean flag = false;
                String list4 = null;
//                long startTime = System.currentTimeMillis();
                // consumer接收
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                    for (ConsumerRecord<String, String> record : records) {
                        list4 = record.value();
//                        long endTime = System.currentTimeMillis();
//                        System.out.println(record.value());
//                        if(endTime - startTime > 1000) list4 = "{\'error\': 'timeout'}";
                        if (list4 != null) {
                            break;
                        }
                    }
                    System.out.println("kafka接受到数据: " + list4);
                    if (list4 != null) break;
                }
                JSONObject jsonObject = JSON.parseObject(list4);

                ReturnType rt = new ReturnType();
                rt.setCode("200");
                rt.setMsg("返回成功");
                rt.setSuccess(true);
                rt.setResult(jsonObject);
                return rt;
            }
            case 4: {
                //producer发送
                producer.send(new ProducerRecord<String, String>("topic_rec2", "endDate", year + "0930"), new Callback() {

                    //回调函数，该方法会在Producer收到ack时调用，为异步调用
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception == null) {
                            System.out.println("kafka数据发送成功");
                        } else {
                            System.out.println("kafka数据发送失败");
                            exception.printStackTrace();
                        }
                    }
                });
                producer.close();

                boolean flag = false;
                String list4 = null;
//                long startTime = System.currentTimeMillis();
                // consumer接收
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                    for (ConsumerRecord<String, String> record : records) {
                        list4 = record.value();
//                        long endTime = System.currentTimeMillis();
//                        System.out.println(record.value());
//                        if(endTime - startTime > 1000) list4 = "{\'error\': 'timeout'}";
                        if (list4 != null) {
                            break;
                        }
                    }
                    System.out.println("kafka接受到数据: " + list4);
                    if (list4 != null) break;
                }
                JSONObject jsonObject = JSON.parseObject(list4);

                ReturnType rt = new ReturnType();
                rt.setCode("200");
                rt.setMsg("返回成功");
                rt.setSuccess(true);
                rt.setResult(jsonObject);
                return rt;
            }
            default: {
                ReturnType rt = new ReturnType();
                rt.setCode("421");
                rt.setMsg("数据库没有该数据");
                rt.setSuccess(true);
                rt.setResult(null);
                return rt;
            }
        }
    }

    @ApiOperation("从数据库读实际重仓股行业数据")
    @GetMapping("/modelResults")
    public ReturnType getModelResult(int year,int quarter){
        Map<String,Object> lists  = new HashMap<>();
        ArrayList<Industry> industryDataReal = new ArrayList<Industry>();
        switch (quarter){
            case 2 : {
                //第二页第二部分数据
                industryDataReal = (ArrayList)inSer.selectTop10(year + "0331");
                lists.put("industryDataReal",industryDataReal);

                ReturnType rt = new ReturnType();
                rt.setCode("200");
                rt.setMsg("返回成功");
                rt.setSuccess(true);
                rt.setResult(lists);
                return rt;
            }
            case 3 : {
                //第二页第二部分数据
                industryDataReal = (ArrayList)inSer.selectTop10(year + "0630");
                lists.put("industryDataReal",industryDataReal);

                ReturnType rt=new ReturnType();
                rt.setCode("200");
                rt.setMsg("返回成功");
                rt.setSuccess(true);
                rt.setResult(lists);
                return rt;
            }
            case 4 : {
                //第二页第二部分数据
                industryDataReal = (ArrayList)inSer.selectTop10(year + "0930");
                lists.put("industryDataReal",industryDataReal);

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

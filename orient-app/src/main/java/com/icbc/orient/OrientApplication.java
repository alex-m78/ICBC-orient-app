package com.icbc.orient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.kafka.annotation.KafkaListener;
// import org.apache.kafka.clients.consumer.ConsumerRecord;

@SpringBootApplication
@MapperScan("com.icbc.orient.Mapper")
public class OrientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrientApplication.class, args);
    }

    //@ApiOperation("kafka消费者测试")
    // @GetMapping("/consumerTest")
    @KafkaListener(topics = {"topic002"})
    public String consumerTest(String msg) {

        System.out.println("i'm in consumer");
        System.out.println(msg);
        return "msg recived";
    }
}

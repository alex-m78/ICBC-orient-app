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

}

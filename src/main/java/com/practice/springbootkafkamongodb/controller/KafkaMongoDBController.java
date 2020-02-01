package com.practice.springbootkafkamongodb.controller;

import com.practice.springbootkafkamongodb.model.Person;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaMongoDBController {

    @Autowired
    private KafkaTemplate<String, Person> kafkaTemplate;
    private static final String TOPIC = "DemoTopic";

    @GetMapping("/publish")
    public String sendMessageToTopic(){
        kafkaTemplate.send(TOPIC, new Person("Steve Jobs","Cupertino", 52, 76879.59));
        return  "Published Person message to TOPIC::"+TOPIC;
    }

}

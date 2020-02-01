package com.practice.springbootkafkamongodb.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.springbootkafkamongodb.model.Person;
import com.practice.springbootkafkamongodb.repository.KafkaMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {
    @Autowired
    private KafkaMongoRepository kafkaMongoRepository;

    @KafkaListener(topics = "DemoTopic", groupId = "group_json")
    public void consumePersonMessage(String message){
        ObjectMapper objectMapper =new ObjectMapper();
        Person person =null;
        try {
            person = objectMapper.readValue(message, Person.class);
            System.out.println("Consumed Person Message::: " + person);
            kafkaMongoRepository.insert(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

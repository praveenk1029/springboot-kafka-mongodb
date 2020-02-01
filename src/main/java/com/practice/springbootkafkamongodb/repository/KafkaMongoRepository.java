package com.practice.springbootkafkamongodb.repository;

import com.practice.springbootkafkamongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KafkaMongoRepository extends MongoRepository<Person, String> {
}

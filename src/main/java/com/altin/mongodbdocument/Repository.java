package com.altin.mongodbdocument;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository  extends MongoRepository<Object, Integer> {
}

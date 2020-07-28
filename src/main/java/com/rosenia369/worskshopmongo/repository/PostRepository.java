package com.rosenia369.worskshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rosenia369.worskshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{

}
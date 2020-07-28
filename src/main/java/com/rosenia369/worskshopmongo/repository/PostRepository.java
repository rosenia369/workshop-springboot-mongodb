package com.rosenia369.worskshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rosenia369.worskshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{

	@Query("{'title': {$regex: ?0, $options: 'i'}}")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{$and: [{date:{$gte: ?1}}, {date:{$lte: ?2}} , {$or:[{'title': {$regex: ?0, $options: 'i'}},{'body': {$regex: ?0, $options: 'i'}},{'comments.text': {$regex: ?0, $options: 'i'}} ]}]}")
	List<Post> searchAll(String text, Date minDate, Date maxDate);
}

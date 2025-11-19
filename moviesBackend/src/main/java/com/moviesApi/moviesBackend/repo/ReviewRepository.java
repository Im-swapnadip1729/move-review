package com.moviesApi.moviesBackend.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moviesApi.moviesBackend.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
    
}

package com.moviesApi.moviesBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.moviesApi.moviesBackend.model.Movie;
import com.moviesApi.moviesBackend.model.Review;
import com.moviesApi.moviesBackend.repo.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String imdbId, String reviewBody) {
        Review review = reviewRepository.insert(new Review(reviewBody)); 
        
        mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviews").value(review))
            .first();
        return review;
        
    }
}

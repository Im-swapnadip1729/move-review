package com.moviesApi.moviesBackend.repo;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moviesApi.moviesBackend.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    // Logic to interact with the database (e.g., using mongoDB operations)
    Optional<Movie> findByImdbId(String imdbId);
    // List<Movie> findByTytel

}

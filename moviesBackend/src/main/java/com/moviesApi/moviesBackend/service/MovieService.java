package com.moviesApi.moviesBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesApi.moviesBackend.model.Movie;
import com.moviesApi.moviesBackend.repo.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        // Logic to fetch all movies from the database
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieByImdbId(String imdbId) {
        // Logic to fetch a movie by its IMDb ID
        return movieRepository.findByImdbId(imdbId);
    }

    // public List<Movie> getMovieByTitle(String title) {
    //     // Logic to fetch a movie by its title
    //     return movieRepository.findByTitleIgnoreCase(title);
    // }
}

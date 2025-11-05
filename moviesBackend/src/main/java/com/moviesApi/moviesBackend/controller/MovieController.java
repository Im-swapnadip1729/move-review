package com.moviesApi.moviesBackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviesApi.moviesBackend.model.Movie;
import com.moviesApi.moviesBackend.service.MovieService;

@RestController
@RequestMapping("/api/movies")// for all requests related to movies
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = movieService.allMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId) {
        Optional<Movie> movie = movieService.getMovieByImdbId(imdbId);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/search")
//     public ResponseEntity<List<Movie>> searchMoviesByTitle(@RequestParam String title) {
//        List<Movie> movies = movieService.getMovieByTitle(title);
//        return ResponseEntity.ok(movies);
//    }


}

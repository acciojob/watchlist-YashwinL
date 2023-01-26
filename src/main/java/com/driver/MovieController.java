package com.driver;


import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
   MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
       return movieService.addMovie(movie);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
       return movieService.addDirector(director);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
       return movieService.addMovieDirectorPair(movie,director);

    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
      return movieService.getMovieByName(name);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getMoviesByDirectorName(@PathVariable String name){
       return movieService.getMoviesByDirectorName(name);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>>  findAllMovies(){
       return movieService.findAllMovies();
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
        return movieService.deleteDirectorByName(name);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
       return movieService.deleteAllDirectors();
    }

}

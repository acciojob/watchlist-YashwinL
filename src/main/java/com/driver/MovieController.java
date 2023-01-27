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

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
       return movieService.addMovie(movie);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
       return movieService.addDirector(director);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movie,@RequestParam("directorName") String director){
       return movieService.addMovieDirectorPair(movie,director);

    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
      return movieService.getMovieByName(name);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        return movieService.getDirectorByName(name);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String name){
       return movieService.getMoviesByDirectorName(name);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
       return movieService.findAllMovies();
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("directedName") String name){
        return movieService.deleteDirectorByName(name);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
       return movieService.deleteAllDirectors();
    }
}

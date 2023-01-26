package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {



    @Autowired
    MovieRepository movieRepository;


    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        return movieRepository.addMovie(movie);
    }


    public ResponseEntity<String> addDirector(@RequestBody Director director){
        return movieRepository.addDirector(director);
    }


    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
       return movieRepository.addMovieDirectorPair(movie,director);

    }


    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
      return movieRepository.getMovieByName(name);
    }


    public ResponseEntity<Director> getMoviesByDirectorName(@PathVariable String name){
       return movieRepository.getMoviesByDirectorName(name);
    }


    public ResponseEntity<List<String>>  findAllMovies(){
        return movieRepository.findAllMovies();
    }


    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
       return movieRepository.deleteDirectorByName(name);
    }


    public ResponseEntity<String> deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }
}

package com.driver;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> moviesdb = new HashMap<>();
    HashMap<String,Director> directordb = new HashMap<>();
    HashMap<String, List<String>> movieAnddirector = new HashMap<>();


    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
       moviesdb.put(movie.getName(),movie);
       return new ResponseEntity<>("Movie added Successfully", HttpStatus.OK);
    }
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        directordb.put(director.getName(),director);
        return new ResponseEntity<>("Director added Successfully",HttpStatus.OK);
    }


    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        if(!movieAnddirector.containsKey(director)){
            movieAnddirector.put(director,new ArrayList<String>());
            return new ResponseEntity<>("Movie and Director pair created Successfully",HttpStatus.OK);
        }
        movieAnddirector.get(director).add(movie);
        return new ResponseEntity<>("Movie and Director pair added Successfully",HttpStatus.OK);

    }


    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        if(moviesdb.containsKey(name)){
            return new ResponseEntity<>(moviesdb.get(name),HttpStatus.OK);
        }
        return null;

    }

    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        if(directordb.containsKey(name)){
            return new ResponseEntity<>(directordb.get(name),HttpStatus.OK);
        }
        return null;

    }


    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name){
        if(movieAnddirector.containsKey(name)){
            return new ResponseEntity<>(movieAnddirector.get(name),HttpStatus.OK);
        }
        return null;

    }


    public ResponseEntity<List<String>>  findAllMovies(){
        List<String> temp = new ArrayList<>();
        for(String i : moviesdb.keySet()){
            temp.add(i);
        }
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
        if(movieAnddirector.containsKey(name)){
            movieAnddirector.remove(name);
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }
        return null;


    }


    public ResponseEntity<String> deleteAllDirectors(){
        movieAnddirector.clear();
        return new ResponseEntity<>("Cleared All",HttpStatus.OK);
    }





}

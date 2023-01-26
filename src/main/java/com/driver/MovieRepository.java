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


    public ResponseEntity<String> addMovie( Movie movie){
       moviesdb.put(movie.getName(),movie);
       return new ResponseEntity<>("Movie added Successfully", HttpStatus.OK);
    }
    public ResponseEntity<String> addDirector(Director director){
        directordb.put(director.getName(),director);
        return new ResponseEntity<>("Director added Successfully",HttpStatus.OK);
    }


    public ResponseEntity<String> addMovieDirectorPair(String movie, String director){
        if(!movieAnddirector.containsKey(director)){
            movieAnddirector.put(director,new ArrayList<String>());
            return new ResponseEntity<>("Movie and Director pair created Successfully",HttpStatus.OK);
        }
        movieAnddirector.get(director).add(movie);
        return new ResponseEntity<>("Movie and Director pair added Successfully",HttpStatus.OK);

    }


    public ResponseEntity<Movie> getMovieByName( String name){
        return new ResponseEntity<>(moviesdb.get(name),HttpStatus.OK);
    }

    public ResponseEntity<Director> getDirectorByName(String name){
        return new ResponseEntity<>(directordb.get(name),HttpStatus.OK);
    }


    public ResponseEntity<Director> getMoviesByDirectorName(String name){
        return new ResponseEntity<>(directordb.get(name),HttpStatus.OK);
    }


    public ResponseEntity<List<String>>  findAllMovies(){
        List<String> temp = new ArrayList<>();
        for(String i : moviesdb.keySet()){
            temp.add(i);
        }
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteDirectorByName( String name){
        movieAnddirector.remove(name);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }


    public ResponseEntity<String> deleteAllDirectors(){
        movieAnddirector.clear();
        return new ResponseEntity<>("Cleared All",HttpStatus.OK);
    }





}

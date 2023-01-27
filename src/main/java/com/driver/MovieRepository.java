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

    HashMap<String,Movie> moviesdb;
    HashMap<String,Director> directordb;
    HashMap<String, List<String>> movieAnddirector;

    public MovieRepository(){
        this.moviesdb = new HashMap<>();
        this.directordb = new HashMap<>();
        this.movieAnddirector = new HashMap<>();
    }


    public ResponseEntity<String> addMovie( Movie movie){
        if(!moviesdb.containsKey(movie.getName())){
            moviesdb.put(movie.getName(),movie);
        }

       return new ResponseEntity<>("Movie added Successfully", HttpStatus.CREATED);
    }
    public ResponseEntity<String> addDirector( Director director){
        if(!directordb.containsKey(director.getName())){
            directordb.put(director.getName(),director);
        }

        return new ResponseEntity<>("Director added Successfully",HttpStatus.CREATED);
    }


    public ResponseEntity<String> addMovieDirectorPair( String movie, String director){
        if(!moviesdb.containsKey(movie) || !directordb.containsKey(director)){
            return new ResponseEntity<>("Movie or Director does not present in database ",HttpStatus.FOUND);
        }
        if(!movieAnddirector.containsKey(director)){
            List<String> lis = new ArrayList<>();
            lis.add(movie);
            movieAnddirector.put(director,lis);
            return new ResponseEntity<>("Movie and Director pair created Successfully",HttpStatus.CREATED);
        }
        movieAnddirector.get(director).add(movie);
        return new ResponseEntity<>("Movie and Director pair added Successfully",HttpStatus.CREATED);

    }


    public ResponseEntity<Movie> getMovieByName( String name){
        if(moviesdb.containsKey(name)){
            return new ResponseEntity<>(moviesdb.get(name),HttpStatus.FOUND);
        }
        return null;

    }

    public ResponseEntity<Director> getDirectorByName( String name){
        if(directordb.containsKey(name)){
            return new ResponseEntity<>(directordb.get(name),HttpStatus.FOUND);
        }
        return null;

    }


    public ResponseEntity<List<String>> getMoviesByDirectorName(String name){
        if(movieAnddirector.containsKey(name)){
            return new ResponseEntity<>(movieAnddirector.get(name),HttpStatus.FOUND);
        }
        return null;

    }


    public ResponseEntity<List<String>>  findAllMovies(){
        List<String> temp = new ArrayList<>();
        for(String i : moviesdb.keySet()){
            temp.add(i);
        }
        return new ResponseEntity<>(temp,HttpStatus.FOUND);
    }

    public ResponseEntity<String> deleteDirectorByName( String name){
        List<String> temp = movieAnddirector.get(name);
        for(int i=0;i<temp.size();i++){
            if(moviesdb.containsKey(temp.get(i))){
                moviesdb.remove(temp.get(i));
            }
        }
        directordb.remove(name);
        if(movieAnddirector.containsKey(name)){
            movieAnddirector.remove(name);
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }
        return null;


    }

    public ResponseEntity<String> deleteAllDirectors(){
        for(String name : movieAnddirector.keySet()){
            List<String> movielist = movieAnddirector.get(name);
            for(String lis : movielist){
                if(moviesdb.containsKey(lis)){
                    moviesdb.remove(lis);
                }
            }
            directordb.remove(name);
        }
        for(String in : directordb.keySet()){
            directordb.remove(in);
        }
        return new ResponseEntity<>("Cleared All",HttpStatus.OK);
    }





}

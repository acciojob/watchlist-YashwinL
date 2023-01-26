package com.driver;

public class Movie {

    //String name, int durationInMinutes, double imdbRating,
    // no-args constructor, all-args constructor and getters-setters

    private String name;
    private int durationInMinutes;
    private double imdbRatings;

    public Movie() {
    }

    public Movie(String name, int durationInMinutes, double imdbRatings) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRatings = imdbRatings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getImdbRatings() {
        return imdbRatings;
    }

    public void setImdbRatings(double imdbRatings) {
        this.imdbRatings = imdbRatings;
    }
}

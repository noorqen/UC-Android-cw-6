package com.example.classfive;

import java.io.Serializable;

public class Movies implements Serializable {
    //1. identifying the data by their type
    private String movieName;
    private int movieHrs;
    private int movieMints;
    private int movieImg;

    //2. generating a Constructor + a Getter and Setter with all the attributes selected
    public Movies(String movieName, int movieHrs, int movieMints, int movieImg) {
        this.movieName = movieName;
        this.movieHrs = movieHrs;
        this.movieMints = movieMints;
        this.movieImg = movieImg;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieHrs() {
        return movieHrs;
    }

    public void setMovieHrs(int movieHrs) {
        this.movieHrs = movieHrs;
    }

    public int getMovieMints() {
        return movieMints;
    }

    public void setMovieMints(int movieMints) {
        this.movieMints = movieMints;
    }

    public int getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(int movieImg) {
        this.movieImg = movieImg;
    }
}

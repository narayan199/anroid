package com.example.movieapp.response;

import com.example.movieapp.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//request for single movie
public class MovieResponse {
    //1-finding the movie object
    @SerializedName("results")
    @Expose()
    private MovieModel movie;

    public MovieModel getMovie() {
        return movie;
    }
    //tostring

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}

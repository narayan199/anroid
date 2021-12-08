package com.example.movieapp.repositiors;

import androidx.lifecycle.LiveData;

import com.example.movieapp.models.MovieModel;
import com.example.movieapp.request.MovieApiClient;

import java.util.List;

//this class is acting as repositores
public class MovieRepositios {
    public static MovieRepositios instance;
    private MovieApiClient movieApiClient;
    public  static  MovieRepositios getInstance()
    {
        if(instance==null)
        {
            return  new MovieRepositios();
        }
        return instance;
    }
    private  MovieRepositios(){
        movieApiClient=MovieApiClient.getInstance();
    }
    public LiveData<List<MovieModel>> getMovies()
    {
        return movieApiClient.getMovies(query, pageNumber);
    }
}

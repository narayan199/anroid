package com.example.movieapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.models.MovieModel;
import com.example.movieapp.repositiors.MovieRepositios;

import java.util.List;

public class MovieListViewModel extends ViewModel {
    //this class for view model
private MovieRepositios movieRepositios;
    //Constructor

    public MovieListViewModel() {
        movieRepositios=MovieRepositios.getInstance();
    }
    public LiveData<List<MovieModel>>getMovies()
    {
        return movieRepositios.getMovies();
    }
}

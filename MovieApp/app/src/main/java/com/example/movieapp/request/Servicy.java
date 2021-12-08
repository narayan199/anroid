package com.example.movieapp.request;

import com.example.movieapp.utils.Credentials;
import com.example.movieapp.utils.MovieApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicy {
    public   static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Credentials.BASEURL);
    public static  Retrofit retrofit = retrofitBuilder.build();
    public static MovieApi movieApi= retrofit.create(MovieApi.class);
    public  static MovieApi getMovieApi()
    {
        return movieApi;
    }
}

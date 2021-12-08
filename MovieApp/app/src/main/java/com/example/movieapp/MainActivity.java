package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieapp.models.MovieModel;
import com.example.movieapp.request.Servicy;
import com.example.movieapp.response.MovieSearchResponse;
import com.example.movieapp.utils.Credentials;
import com.example.movieapp.utils.MovieApi;
import com.example.movieapp.viewmodel.MovieListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView textView;

    //ViewModel
    private MovieListViewModel movieListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        btn= findViewById(R.id.button);
        textView=findViewById(R.id.textView);


    }

    private void getRetrofitResponse() {
        MovieApi movieApi = Servicy.getMovieApi();
        Call<MovieSearchResponse> responseCall= movieApi
                .searchMovie(Credentials.APIKEY,"Action");
        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {

                assert response.body() != null;
                List<MovieModel>movies = new ArrayList<>(response.body().getMovies());
                //Toast.makeText(MainActivity.this,"hello", Toast.LENGTH_SHORT).show();
            for (MovieModel movieModel:movies)
                {
                    Toast.makeText(MainActivity.this, movieModel.getTitle(), Toast.LENGTH_SHORT).show();
              }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getRetrofitResponseByid(){
        MovieApi movieApi=Servicy.getMovieApi();
        Call<MovieModel>call = movieApi.getMovieById(550,Credentials.APIKEY);
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                assert response.body() != null;
                Toast.makeText(MainActivity.this, response.body().getTitle().toUpperCase(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
    }

    //observe data any change
    private void observerAnyChange()
    {
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                //observeing for any data chnage
            }
        });
    }
}
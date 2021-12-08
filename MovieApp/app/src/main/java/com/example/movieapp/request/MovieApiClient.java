package com.example.movieapp.request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.AppExecutors;
import com.example.movieapp.models.MovieModel;
import com.example.movieapp.response.MovieSearchResponse;
import com.example.movieapp.utils.Credentials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class MovieApiClient {
    //live data
    private MutableLiveData<List<MovieModel>> mMovies;
    private static MovieApiClient instance;
    private ReteriveMOviesRunnable reteriveMOviesRunnable;

    public static MovieApiClient getInstance() {
        if (instance == null) {
            return new MovieApiClient();
        }
        return instance;
    }

    private MovieApiClient() {
        mMovies = new MutableLiveData<>();
    }

    public LiveData<List<MovieModel>> getMovies(String query, int pageNumber) {
        return mMovies;
    }


    public void searchMovieApi(String query,int PageNumber) {
        if (reteriveMOviesRunnable!=null)
        {
            reteriveMOviesRunnable=null;
        }

        reteriveMOviesRunnable = new ReteriveMOviesRunnable(query,PageNumber);
        final Future myHandler = AppExecutors.getInstance().getmNetwrokIO().submit();
        AppExecutors.getInstance().getmNetwrokIO().schedule(new Runnable() {
            @Override
            public void run() {
                //canceling retrofit call
                myHandler.cancel(true);
            }

        }, 4000, TimeUnit.MICROSECONDS);
        /* reterving live data */

    }
    //Reteriving data
    private class ReteriveMOviesRunnable implements Runnable{
    private String query;
    private int pageNumber;
    boolean cancelRequest;

        public ReteriveMOviesRunnable(String query, int pageNumber) {
            this.query = query;
            this.pageNumber = pageNumber;
            cancelRequest=false;
        }

        @Override
        public void run() {
            //response
            try {
                Response response = getMovies(query, pageNumber).execute();
                if (cancelRequest) {
                    return;
                }
                if (response.code() == 200) {
                    List<MovieModel> list;
                    list = new ArrayList<>(((MovieSearchResponse) response.body()).getMovies());
                    if(pageNumber==1)
                    {
                        //sending data to livedata
                        mMovies.postValue(list);
                    }else {
                        List<MovieModel>currentMovie=mMovies.getValue();
                        currentMovie.addAll(list);
                    }
                }else {
                    String error =response.errorBody().toString();
                    mMovies.postValue(null);

                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
                mMovies.postValue(null);
            }

        }
        private Call<MovieSearchResponse>getMovies(String query,int pageNumber)
        {
            return Servicy.getMovieApi().searchMovie(
                    Credentials.APIKEY,query,pageNumber
            );
        }

        private void cancelRequest()
        {
            Log.v("Tag","canceling request");
            cancelRequest=true;
        }
    }
}



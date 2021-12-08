package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("a5970b47-72d1-4201-8be0-38f0223b9c85")
    Call<Pojo> getRequest();
}

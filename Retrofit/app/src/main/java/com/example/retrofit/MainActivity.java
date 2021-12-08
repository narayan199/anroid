package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    protected  static final  String url ="https://run.mocky.io/v3/";
    TextView textView;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.textview);
        gson  = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(url).build();
        ApiRequest apiRequest = retrofit.create(ApiRequest.class);
        Call<Pojo> call = apiRequest.getRequest();
        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                assert response.body() != null;
                textView.setText(response.body().getName());
                Toast.makeText(MainActivity.this, "Sucess", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {
                  textView.setText(t.getMessage());
            }
        });
    }

}
package com.codevscolor.retrofitdemo.activity;
import com.codevscolor.retrofitdemo.R;
import com.codevscolor.retrofitdemo.model.GitRepoModel;
import com.codevscolor.retrofitdemo.restapi.APIService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<List<GitRepoModel>> {
    private static final String ENDPOINT = "http://api.github.com/";
    private static final String TAG = "RETRODEMO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIService githubUserAPI = retrofit.create(APIService.class);

        Call<List<GitRepoModel>> call = githubUserAPI.getRepos("codevscolor");

        //asynchronous call
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<GitRepoModel>> call, Response<List<GitRepoModel>> response) {
        int code = response.code();

        if (code == 200) {

            for(int i=0;i< response.body().size();i++){
                Log.d(TAG,response.body().get(i).getName());
            }

        } else {

        }
    }


    @Override
    public void onFailure(Call<List<GitRepoModel>> call, Throwable t) {

    }
}

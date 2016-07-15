package com.codevscolor.retrofitdemo.restapi;

import com.codevscolor.retrofitdemo.model.GitRepoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface APIService {

    @GET("users/{user}/repos")
    Call<List<GitRepoModel>> getRepos(@Path("user") String user);
}

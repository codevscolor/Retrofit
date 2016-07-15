package com.codevscolor.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

public class GitRepoModel {
    @SerializedName("name")
    private String name;

    public String getName(){
        return name;
    }
}

package com.example.maksim.newsproject.RetrofitAPI;

import com.example.maksim.newsproject.Model.SourceNews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Maksim on 17.12.2016.
 */

public interface API {

    @GET("/v1/sources")
    Call<SourceNews> getPost();

}

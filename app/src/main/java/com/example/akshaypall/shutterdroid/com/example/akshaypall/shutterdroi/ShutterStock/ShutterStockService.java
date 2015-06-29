package com.example.akshaypall.shutterdroid.com.example.akshaypall.shutterdroi.ShutterStock;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Akshay Pall on 19/05/2015.
 */
interface ShutterStockService {

    @GET("/images/search")
    public void searchImages(@Query("query") String query, Callback<Response> cb);

    @GET("/images/search")
    public void getRecent(@Query("added_date_start") String date, Callback<Response> cb);
}

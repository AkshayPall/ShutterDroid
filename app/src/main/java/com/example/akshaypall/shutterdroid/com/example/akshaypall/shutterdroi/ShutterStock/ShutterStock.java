package com.example.akshaypall.shutterdroid.com.example.akshaypall.shutterdroi.ShutterStock;

import android.util.Base64;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by Akshay Pall on 19/05/2015.
 */
public class ShutterStock {
    private static final String API_URL = "https://api.shutterstock.com/v2";

    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade requestFacade) {
                    String clientID = "95cbb521422de8c173d2:940b31e8f4180dd6020021fed3bde5c0c46a3989";
                    String auth = "Basic "+ Base64.encodeToString(clientID.getBytes(), Base64.NO_WRAP);
                    requestFacade.addHeader("Authorization", auth);
                }
            })
            .build();
    private static final ShutterStockService SERVICE = REST_ADAPTER.create(ShutterStockService.class);

    public static void search(String query, Callback<List<SImages>> cb) {
        SERVICE.searchImages(query, new ImageCallback(cb));
    }

    public static void getRecent(Date date, Callback<List<SImages>> cb) {
        SERVICE.getRecent(new SimpleDateFormat("yyyy-MM-dd").format(date), new ImageCallback(cb));
    }

    private static class ImageCallback implements Callback<Response> {
        Callback<List<SImages>> cb;
        ImageCallback(Callback<List<SImages>> cb) {
            this.cb = cb;
        }
        @Override
        public void success(Response response, retrofit.client.Response response2) {
            cb.success(response.data, response2);
        }

        @Override
        public void failure(RetrofitError error) {
            cb.failure(error);
        }
    }
}

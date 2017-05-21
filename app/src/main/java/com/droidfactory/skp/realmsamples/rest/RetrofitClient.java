package com.droidfactory.skp.realmsamples.rest;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shashi Pal on 5/21/2017.
 */

public class RetrofitClient {

    public static final String BASE_URL = "http://api.themoviedb.org/3/";

    public final static String API_KEY = "f31007a11ad0f583d1e822ea1abdb736";

    private static Retrofit retrofit = null;


    public static Retrofit getClient() {

        /*OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new StethoInterceptor());*/
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}

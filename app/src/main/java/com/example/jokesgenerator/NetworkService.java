package com.example.jokesgenerator;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService mInstance;
    private static Retrofit mRetrofit;
    private static final String BASE_URL = "http://api.icndb.com";

    public NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance(){
        if(mInstance == null)
            mInstance = new NetworkService();
        return mInstance;
    }

    public JsonJokesApi getJsonJokesApi(){
        return mRetrofit.create(JsonJokesApi.class);
    }
}

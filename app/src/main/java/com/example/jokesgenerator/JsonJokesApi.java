package com.example.jokesgenerator;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonJokesApi {
    @GET("/jokes/random/{count}")
    Call<JokeModel> getJokes(@Path("count") int count);
}

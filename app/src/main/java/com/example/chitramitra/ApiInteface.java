package com.example.chitramitra;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInteface {
    @GET("/")
    Call<com.example.chitramitra.MovieResults> getMovies(@Query("s") String title,
                                                        @Query("apikey") String apiKey);
    @GET("/3/movie/now_playing")
    Call<Root> getMoviesHomePage();

}

package com.udacoding.moviepaging.network

import com.udacoding.moviepaging.model.ResponseMovies
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/5/lists")
    fun getData(
        @Query("api_key") apiKey: String,
        @Query("language=en-US") language: String,
        @Query("page") page: Long,
        @Query("total_result") result: Int
    ): Flowable<ResponseMovies>

}
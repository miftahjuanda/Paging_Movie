package com.udacoding.moviepaging.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceApi {

    companion object {
        val baseUrl = "https://api.themoviedb.org/3/"

        fun serviceApi(): MoviesService {
            //step1 configurasi interceptor
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okhttp = OkHttpClient().newBuilder().addInterceptor(interceptor).build()


            //step2 config retrofit
            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .client(okhttp)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()

            //step3 include config retrofit ke interface
            return retrofit.create(MoviesService::class.java)
        }
    }
}
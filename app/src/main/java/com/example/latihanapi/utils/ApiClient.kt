package com.example.latihanapi.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    var retrofit: Retrofit? = null

    companion object {
        val BASE_URL: String = "http://172.168.10.10/latianApi/public"
        val IMAGE_URL: String = "$BASE_URL/image/"
        val API_URL = "$BASE_URL/api/"
    }

    fun getClient(): Retrofit {
        if (retrofit == null) {

            retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}
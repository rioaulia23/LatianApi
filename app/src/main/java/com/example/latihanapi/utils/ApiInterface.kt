package com.example.latihanapi.utils

import com.example.latihanapi.models.ModelProduct
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("product")
    fun getProduct(): Call<ArrayList<ModelProduct>>
}
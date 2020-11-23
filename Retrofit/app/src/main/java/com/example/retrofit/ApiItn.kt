package com.example.retrofit


import com.example.retrofit.Models.UrlModels
import retrofit2.Call
import retrofit2.http.GET

interface ApiItn {
    @GET("meow")
    fun getFile(): Call<UrlModels>
}
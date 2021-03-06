package com.example.retrofittest.api

import com.example.retrofittest.model.Post
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost(): Post
}
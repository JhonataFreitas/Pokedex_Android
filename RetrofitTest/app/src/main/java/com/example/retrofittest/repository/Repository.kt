package com.example.retrofittest.repository

import com.example.retrofittest.api.RetrofitInstance
import com.example.retrofittest.model.Post

class Repository {

    suspend fun getPost():Post {
        return RetrofitInstance.api.getPost()
    }
}
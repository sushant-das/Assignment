package com.mg.assignment.utils

import com.mg.assignment.pojo.Data
import com.mg.assignment.pojo.User
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("blogs?page=1&limit=10")
    fun getArticleData(): Call<List<Data>>
}
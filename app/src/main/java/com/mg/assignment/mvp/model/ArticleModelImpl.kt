package com.mg.assignment.mvp.model

import com.mg.assignment.pojo.Data
import com.mg.assignment.utils.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ArticleModelImpl {

    interface OnLoginFinishedListener {

        fun onFailure(message: String?)
        fun onSuccess(list: List<Data>?)
    }

    fun callArticleAPI(listener: OnLoginFinishedListener) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://5e99a9b1bc561b0016af3540.mockapi.io/jet2/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(APIInterface::class.java)
        val call = service.getArticleData()
        call.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (response.code() == 200) {
                    val list=response.body()
                    listener.onSuccess(list)
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                listener.onFailure(t.message)
            }
        })
    }
}
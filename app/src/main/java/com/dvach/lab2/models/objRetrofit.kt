package com.dvach.lab2.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object objRetrofit {

    fun createRetrofit() : RepoApi  {
        // For GsonConverterFactory
        val retrofit = Retrofit.Builder()
            .baseUrl("http://practice.mobile.kreosoft.ru/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RepoApi::class.java)
    }
}
package com.dvach.lab2.models

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object objRetrofit {

    private var _instance: RepoApi? = null
    lateinit var sPref: SharedPreferences
    var savedToken: String? = null
    var kaef: Boolean = false

    fun createRetrofit(context: Context, MainActivity: Activity): RepoApi {
        loadText(MainActivity)
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()

                val requestBuilder = original.newBuilder()
                    .header(
                        "Authorization", "Bearer " + savedToken
                    )
                    .method(original.method(), original.body())
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()


        val instance = _instance

        if (instance != null) return instance

        val newInstance = Retrofit
            .Builder()
            .baseUrl("http://practice.mobile.kreosoft.ru/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build().create(RepoApi::class.java)

        _instance = newInstance
        return newInstance
    }

    fun loadText(MainActivity: Activity) {
        sPref = MainActivity.getSharedPreferences("kek", Context.MODE_PRIVATE)
        if (sPref.contains("token")) {
            savedToken = sPref.getString("token", "")
            kaef = true
        }
    }
}
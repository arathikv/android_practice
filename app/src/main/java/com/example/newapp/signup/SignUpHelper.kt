package com.example.newapp.signup
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object SignUpHelper {
    private const val baseUrl="http://172.16.4.72:8089/car/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
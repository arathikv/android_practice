package com.example.newapp.signup

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SignUpInterface {
    @POST("users")
    suspend fun authenticate(@Body request: SignUp2): Response<SignUpResponse2>
}
package com.example.newapp.signup

import com.google.gson.annotations.SerializedName
import okhttp3.internal.http2.ErrorCode

data class SignUpResponse2(
    @SerializedName("userName") var userName:String,
    @SerializedName("userMail")var userMail:String,
    @SerializedName("errorCode") var errorCode:String,
    @SerializedName("errorMessage") var errorMessage: String
)

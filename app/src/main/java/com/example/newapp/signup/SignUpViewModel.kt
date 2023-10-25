package com.example.newapp.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SignUpViewModel:ViewModel() {
    val liveData:MutableLiveData<SignUpResponse2> = MutableLiveData()

//    fun makeApiRequest(email: String, password: String,phoneNumber: String,userName:String) {
        fun makeApiRequest(email: String, password: String,phoneNumber: Int,userName:String) {

        val retrofit=SignUpHelper.getInstance()
        val apiService = retrofit.create(SignUpInterface::class.java)


        val request = SignUp2(userPassword = password, userPhone = phoneNumber, userMail = email, userName = userName)

        viewModelScope.launch() {

                println("ppppppppppp")
                val user = apiService.authenticate(request)
                liveData.value = user.body()
                if(user.isSuccessful) {
                        println("huuuuu ${user.code()}")
                        println(user)
                        println("User details: $user")
                }
                else {
                        println(user.errorBody().toString())
                }
//                else{
//                        println("User details: ${user.body()}")
//                        println(user)
//                }

        }

    }

}
package com.example.test.networkCall

import com.example.test.data.Users
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BasicApiService {

    @GET("api")
    fun getAllUsers(@Query("results") vale:String ) : Single<Users>
}
package com.example.alena6.data.retrofit

import retrofit.http.Field
import retrofit.http.POST


interface PostService {

    @POST("/order")
    fun sendData(@Field("size") size: String, @Field("type") type: String)

}
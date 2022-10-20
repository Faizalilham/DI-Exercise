package com.example.makeupapi.api

import com.example.makeupapi.model.MakeUpItem
import retrofit2.Call
import retrofit2.http.*

interface RestfulApi {

    @GET("products.json")
    fun getAllMakeUp(): Call<MutableList<MakeUpItem>>

}
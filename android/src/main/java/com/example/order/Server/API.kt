package com.example.order.datasource.Server

import com.example.order.app.domain.model.ListItem
import retrofit2.Call
import retrofit2.http.*

interface API {

    @GET("GET")
    fun getDataRemoteServer(

    ): Call<List<ServerResponseData>>

    @POST("SET")
    fun pullDataToRemoteServer(@Body result:List<ListItem>):Call<List<ServerResponseData>>





}
package com.example.myapplication.dongbo_batdongbo



import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface api {
    @GET("api/users?page=2}")
    fun get_users(

    ): Call<list_user>

    @GET("api/unknown")
    fun get_resource()
            : Call<list_resource>
}

package com.example.myapplication.dongbo_batdongbo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.myapplication.R

import kotlinx.coroutines.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis

class MainActivity:Fragment(){

    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?
                              , savedInstanceState: Bundle?):View? {

        var view: View =inflater.inflate(R.layout.fragment_main_activity, container, false)
//        GlobalScope.launch {
//            suspend fun deferedrun() = coroutineScope {
//                val time = measureTimeMillis {
//                    val defererun1 = async {
//                        delay(500)
//                        var retrobuile = Retrofit.Builder()
//                            .addConverterFactory(GsonConverterFactory.create())
//                            .baseUrl("https://reqres.in")
//                            .build()
//                        var jsonapi = retrobuile.create(api::class.java)
//                        val call = jsonapi.get_users()
//                        call.enqueue(object : Callback<list_user> {
//                            override fun onResponse(
//                                call: Call<list_user>,
//                                response: Response<list_user>
//                            ) {
//                                println(response.body()?.page)
//                            }
//
//                            override fun onFailure(call: Call<list_user>, t: Throwable) {
//                                TODO("Not yet implemented")
//                            }
//                        })
//                    }
//                }
//                println("Time1$time")
//            }
//        }
        runBlocking { deferedrun() }
        return view
    }


    suspend fun deferedrun()= coroutineScope {
        val time= measureTimeMillis {
            val defererun1=async {
                delay(1000)
                var retrobuile=Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://reqres.in")
                    .build()
                var jsonapi=retrobuile.create(api::class.java)
                val call=jsonapi.get_users()
                call.enqueue(object :Callback<list_user>{
                    override fun onResponse(call: Call<list_user>, response: Response<list_user>) {
                        println(response.body()?.page)
                    }

                    override fun onFailure(call: Call<list_user>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })
            }.join()
            val defererun2=async {
                delay(1000)
                var retrobuile=Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://reqres.in")
                    .build()
                var jsonapi=retrobuile.create(api::class.java)
                val call=jsonapi.get_resource()
                call.enqueue(object :Callback<list_resource>{
                    override fun onResponse(call: Call<list_resource>, response: Response<list_resource>) {
                        println(response.body()?.page+"///////////////////,,,,,,,,,,,,,....")
                    }

                    override fun onFailure(call: Call<list_resource>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })
            }
        }
        println("Time:$time")
    }
}
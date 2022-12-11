package com.example.redesignandroidcashierkt.dataSource.network

import com.example.redesignandroidcashierkt.pojo.ItemsModel
import retrofit2.Call
import retrofit2.http.*
import java.util.HashMap

interface CashierAPI {



    @Headers("Content-Type: application/json")
    @GET("GetProductsTestPagination")
    fun getItemsPagnation(
        @Query("Count") count: Int,
        @Query("Cursor") Cursor: Int
    ): Call<ItemsModel?>?


}
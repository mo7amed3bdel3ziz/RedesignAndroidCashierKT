package com.example.redesignandroidcashierkt.repository

import com.example.redesignandroidcashierkt.dataSource.network.CashierAPI
import com.example.redesignandroidcashierkt.pojo.ItemsModel
import com.example.redesignandroidcashierkt.pojo.Tasks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.await
import javax.inject.Inject

interface SalesRepository  {



}
    class SalesRepositoryImpl @Inject constructor(private val api: CashierAPI) : SalesRepository {

        override fun getItemInfo(userID: String, customerID: String, itemID: String): Flow<ItemsModel> =
        flow {
            try {
                val response =
                    api.getItemsPagnation(
                        
                    )

            } catch (ex: Exception) {
            }

        }.flowOn(Dispatchers.IO)
}
    }
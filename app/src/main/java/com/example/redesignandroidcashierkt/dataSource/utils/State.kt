package com.example.redesignandroidcashierkt.dataSource.utils

sealed class State<out T>{
    data class Success<T> (val data:T): State<T>()
    data class Error (val messag:String): State<Nothing>()
    object Loading : State<Nothing>()
    fun toData():T? =if (this is Success) data else null
    fun toError():String =if (this is Error) messag else "E..."
    fun toLoading(): String =if (this is Loading) "Loding..." else "L..."

}

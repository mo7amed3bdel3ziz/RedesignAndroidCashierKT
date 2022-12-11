package com.example.redesignandroidcashierkt.pojo

data class Tasks<T>(
    var State :Int,
    var data :List<T>,
    var Message :String,
    val Item : T?
)
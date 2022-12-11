package com.example.redesignandroidcashierkt.pojo

data class ItemsModel(
    var Selling_Price: Double? = null,
    var ItemName: String? = null,
    var Barcode: String? = null,
    var balanc: Double? = 0.0,
    var contaty: Double? = 1.0,
    // salying -> 0,
    //returns -> 1,
    var documentType: Int = 1,

    var State: Int = 0,
    var Message: String? = null,

    var sales_id: Int = 1,

    var SR_No: Int = 1,
    var Description: String? = "sample string 2",
    var UnitPrice: Double? = 1.0,
    var Suppier_id: Int = 1,
    var size: Double? = 1.0,
    var Discount: Double? = 1.0,
    var Supply_Price: Double? = 1.0,


    var BillNo: Int = 1,
    var ItemID: Int = 1,

)

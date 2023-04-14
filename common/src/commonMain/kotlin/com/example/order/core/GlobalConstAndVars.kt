package com.example.order.core

import com.example.order.app.domain.model.ListItem
import com.example.order.datasource.Server.ServerResponseData

object GlobalConstAndVars {
    const val qrForloading="1234567"
    const val UID="nvrsk000001"
    var CELLS_STRING=""
    var DATA_FROM_USB=""
    var ANSWER_CLICKED:ListItem=ListItem("","","","","","")
    var CHOSEN_LIST_ITEM=ListItem("","","","","","")
    var CELLS_LIST:List<ListItem> = mutableListOf(
        ListItem(UID,"5","123456","","",""),
        ListItem(UID,"12","123456","","",""))
    var RIGHT_ANSWER:ListItem=ListItem("","","","","","")
    var listItemFromDb:List<ListItem> = mutableListOf()
    var DATABASE1C_NAME: String = "Database1C.db"
    val DEFAULT_lIST= listOf(ListItem("","","","","",""))
    var GLOBAL_LIST= DEFAULT_lIST
    var LIST_OF_FINISHED_ORDERS = listOf<ServerResponseData>()
    var ORDERS_NUMBER:String=""
    var GOOD_TO_LOAD:String=""

}
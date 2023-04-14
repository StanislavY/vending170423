package com.example.order.datasource.Server

import com.google.gson.annotations.SerializedName

data class ServerResponseData(



    @SerializedName("ВидОбъекта") var id1: String?,
    @SerializedName("Код") var id2: String?,
    @SerializedName("Наименование") val name: String?,
    @SerializedName("Расценка") val value: String?


)

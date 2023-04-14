package com.example.order.Room.DataBaseFrom1C

import androidx.room.Entity


@Entity(primaryKeys = ["box","cell","specificationsName"])
data class DatabaseFrom1CEntity(

    var box: String,
    var cell: String,
    var specificationsName:String,
    var value:String,
    var reserveField1:String,
    var reserveField2:String


)
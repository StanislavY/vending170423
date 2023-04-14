package com.example.order.app.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(var collection: String, var documentFB: String, var field:String, var value:String, var theme:String,var typeOftest:String):Parcelable


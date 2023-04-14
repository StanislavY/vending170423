package com.example.order.app.domain.model

import android.text.Spannable
import android.text.SpannableString

data class SearchItem (
   val id1:Spannable,
   val id2:Spannable,
   val name: Spannable,
   val value:Spannable
) {
    constructor(id1:String, id2:String, name: String,value:String) : this(SpannableString(id1), SpannableString(id2), SpannableString(name),SpannableString(value))
}

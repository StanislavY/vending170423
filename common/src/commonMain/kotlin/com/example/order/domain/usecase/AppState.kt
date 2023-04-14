package com.example.order.app.domain.usecase

import com.example.order.app.domain.model.ListItem

sealed class AppState {
    data class Success(val listItem: List<ListItem>,): AppState()
    data class SuccessCells(val tickets:List<ListItem>):AppState()
    data class Error(val error:Throwable): AppState()
    data class Loading(val progress:Int?): AppState()

}
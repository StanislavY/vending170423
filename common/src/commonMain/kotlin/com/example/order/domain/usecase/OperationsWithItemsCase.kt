package com.example.order.app.domain.usecase

import com.example.order.app.domain.model.ListItem


interface OperationsWithItemsCase {
   suspend fun getCellsToOpen(orderNumber: String):List<ListItem>
   suspend fun openCellForLoading(goodsArticle:String)
   suspend fun getFreeCellsList (freeCellsList:List<ListItem>)


}
package com.example.order.app.domain.usecase

import com.example.order.app.domain.model.ListItem

interface LoadDataFromRemoteServerCase {
   fun  executeDeletingDataFromDb()
   fun executeDownloadingDataFromServerToDB(listItemFromServer:List<ListItem>)
   suspend fun executeDownloadingDataFromFireBaseToLocalDB(listItemFromFB:List<ListItem>)
}
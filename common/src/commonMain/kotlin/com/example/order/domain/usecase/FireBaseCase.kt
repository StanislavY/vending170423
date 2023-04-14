package com.example.order.app.domain.usecase

import com.example.order.app.domain.model.ListItem
import com.example.order.app.domain.model.ServerResponseDataFireBase

interface FireBaseCase{
  suspend fun executeGettingDataFromFirebase(collectionsName:String):MutableList<ListItem>
    suspend fun executeAddingDataToFirebase(collectionsName: String): MutableList<ListItem>
    suspend fun executeListeningChangesInDocumentFirebase(collectionsName: String): MutableList<ListItem>
}
package com.example.order.app.domain.usecase

import com.example.order.repository.LocalRepository
import com.example.order.repository.LocalRepositoryImpl
import com.example.order.app.domain.model.ListItem
import com.example.order.core.App

class LoadDataFromRemoteServerCaseImpl:LoadDataFromRemoteServerCase {
    private val localRepository:LocalRepository=LocalRepositoryImpl(App.get1CDAO())
    override fun executeDeletingDataFromDb() {
        localRepository.deleteAllData()
    }

    override fun executeDownloadingDataFromServerToDB(listItemFromServer:List<ListItem>) {
        localRepository.putDataFromServer1CToLocalDatabase(listItemFromServer)
    }

    override suspend fun executeDownloadingDataFromFireBaseToLocalDB(listItemFromFB: List<ListItem>) {
        localRepository.putDataFromFBToLocalDatabase(listItemFromFB)
    }
}
package com.example.order.repository

import com.example.order.app.domain.model.ListItem
import com.example.order.datasource.Room.DataBaseFrom1C.DatabaseFrom1CEntity
import com.example.order.datasource.Room.DatabaseResult.ResultEntity

interface LocalRepository {
    fun putDataFromServer1CToLocalDatabase(listItemFromServer:List<ListItem>)
    fun getAllDataDB1CEntity(): List<ListItem>
    fun deleteAllData()
    fun insertToDB(data: DatabaseFrom1CEntity)
    suspend fun putDataFromFBToLocalDatabase(listItemFromServer: List<ListItem>)


}
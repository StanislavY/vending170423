package com.example.order.repository

import com.example.order.app.domain.model.ListItem
import com.example.order.datasource.Room.DataBaseFrom1C.DatabaseFrom1CDAO
import com.example.order.datasource.Room.DataBaseFrom1C.DatabaseFrom1CEntity
import com.example.order.app.domain.usecase.Converters

class LocalRepositoryImpl(private val localDataSource: DatabaseFrom1CDAO) : LocalRepository {
    private val converter: Converters = Converters()
    override fun putDataFromServer1CToLocalDatabase(listItemFromServer: List<ListItem>) {
       for (mainList in listItemFromServer) {
           /*val data:DatabaseFrom1CEntity=converter.convertMainListToEntityDB1C(mainList.id1,mainList.id2,mainList.name,mainList.value)*/
           val data=DatabaseFrom1CEntity(mainList.collection,mainList.documentFB,mainList.field,mainList.value,"","")
            insertToDB(data)

          }

    }
    override suspend fun putDataFromFBToLocalDatabase(listItemFromServer: List<ListItem>) {
        for (mainList in listItemFromServer) {
            /*val data:DatabaseFrom1CEntity=converter.convertMainListToEntityDB1C(mainList.id1,mainList.id2,mainList.name,mainList.value)*/
            val data=DatabaseFrom1CEntity(mainList.collection,mainList.documentFB,mainList.field,mainList.value,mainList.theme,mainList.typeOftest)
            insertToDB(data)

        }

    }

    override fun insertToDB(data:DatabaseFrom1CEntity){
        localDataSource.insert(data)


    }

    override fun getAllDataDB1CEntity():List<ListItem> {
        return converter.convertEntityDB1CToMainList(localDataSource.all1C())

    }

    override fun deleteAllData(){
        localDataSource.deleteall()
    }


}


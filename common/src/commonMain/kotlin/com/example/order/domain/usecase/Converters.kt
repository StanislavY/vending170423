package com.example.order.app.domain.usecase

/*import androidx.lifecycle.ViewModel*/
import com.example.order.app.domain.model.SearchItem
import com.example.order.app.domain.model.ListItem
import com.example.order.app.domain.model.ServerResponseDataFireBase
import com.example.order.datasource.Room.DataBaseFrom1C.DatabaseFrom1CEntity
import com.example.order.datasource.Room.DatabaseResult.ResultEntity
import com.example.order.datasource.Server.ServerResponseData
import com.google.firebase.firestore.DocumentSnapshot
import java.util.*
import kotlin.collections.ArrayList

open class Converters /*: ViewModel()*/ {
    fun converterFromResponseServerToMainList(serverResponse: List<ServerResponseData?>): List<ListItem> {
        val convertedListItem: MutableList<ListItem> = mutableListOf()

        for (list in serverResponse) {
            if (list != null) {
                convertedListItem.add(
                    convertMainListFromStrings(
                        list.id1,
                        list.id2,
                        list.name,
                        list.value, "","")
                    )

            }

        }

        return convertedListItem

    }

    private fun convertMainListFromStrings(
        id1: String?,
        id2: String?,
        name: String?,
        value: String?,

        theme:String,typeOftest:String
    ): ListItem {
        return ListItem(id1!!, id2!!, name!!, value!!,theme,typeOftest)

    }

    fun convertMainListToEntityDB1C(
        id1: String,
        id2: String,
        name: String,
        value: String
    ): DatabaseFrom1CEntity {
        val databaseFrom1CEntity = DatabaseFrom1CEntity("", "", "", "", "", "")
        databaseFrom1CEntity.box = id1
        databaseFrom1CEntity.cell = id2
        databaseFrom1CEntity.specificationsName = name
        databaseFrom1CEntity.value = value
        return databaseFrom1CEntity
    }

    fun convertEntityDB1CToMainList(entityList: List<DatabaseFrom1CEntity>): List<ListItem> {
        return entityList.map {
            ListItem(it.box, it.cell, it.specificationsName, it.value,it.reserveField1,it.cell)

        }


    }

    fun mapDocumentToRemoteTask(document: DocumentSnapshot) = document.toObject(
        ServerResponseDataFireBase::class.java
    )!!.apply { documentFB = document.id }

    fun mapServerResponseDataFireBaseToListItem(remoteTask: ServerResponseDataFireBase): ListItem {


        return ListItem(
            remoteTask.collection,
            remoteTask.documentFB,
            remoteTask.field,
            value = remoteTask.value,
            theme = remoteTask.theme,
            remoteTask.typeOfTests

        )
    }

    fun mapServerResponseDataFireBaseToDBEntity(remoteTask: ServerResponseDataFireBase): DatabaseFrom1CEntity {


        return DatabaseFrom1CEntity(
            remoteTask.collection,
            remoteTask.documentFB,
            remoteTask.field,
            value = remoteTask.value,
            reserveField1 = remoteTask.theme,
            reserveField2 = remoteTask.typeOfTests

        )
    }

    fun mapDocumentToServerResponseDataFireBase(
        document: DocumentSnapshot,
        collection: String
    ): MutableList<ServerResponseDataFireBase> {
        var result: MutableList<ServerResponseDataFireBase> = mutableListOf()
        var themeForList =""
        var typeOfTestDB =""

        var hashMap = document.data
        if (hashMap != null) {
            for (i in hashMap) {
                var item = ServerResponseDataFireBase("", "", "", "")
                item.collection = collection
                item.documentFB = document.id
                if (i.key.toString() == "part") {
                    typeOfTestDB=i.value.toString()

                }
                if (i.key.toString() == "theme") {
                    themeForList=i.value.toString()
                }

                else {
                    item.field = i.key.toString()
                    item.value = i.value.toString()
                    result.add(item)
                }
                for (serverResponseDataFireBase in result) {
                    serverResponseDataFireBase.theme=themeForList
                    serverResponseDataFireBase.typeOfTests=typeOfTestDB

                }


            }

        }
        return result
    }


    fun convertEntityResultToMainList(entityList: List<ResultEntity>): List<ListItem> {
        return entityList.map { ListItem(it.id1, it.id2, it.name, it.uid,"","") }
    }

    fun convertRemListToResultEntity(remListItem: List<ListItem>): List<ResultEntity> {
        val uid = UUID.randomUUID().toString()
        return remListItem.map {
            ResultEntity(
                it.collection, it.documentFB, it.field, it.value, uid

            )
        }

    }

    fun convertEntityResultToMainListForOrederList(entityList: List<ResultEntity>):List<ListItem>{
        return entityList.map {  ListItem(it.uid, it.id1, it.name, it.value,"","") }
    }

    fun convertItemStorageToMainList(arrayList:ArrayList<SearchItem>):List<ListItem>{
        val mainList= mutableListOf<ListItem>()
        for (item in arrayList) {
            mainList.add(ListItem(item.id1.toString(),item.id2.toString(),item.name.toString(),item.value.toString(),"",""))


        }
        return mainList

    }
    fun convertListItemToItemStorage(listItem:List<ListItem>):ArrayList<SearchItem>{
        val arrListOfItemStorage= ArrayList<SearchItem>()
        for (mainList in listItem) {
            arrListOfItemStorage.add(SearchItem(mainList.collection,mainList.documentFB,mainList.field,mainList.value))


        }
        return arrListOfItemStorage


    }

}











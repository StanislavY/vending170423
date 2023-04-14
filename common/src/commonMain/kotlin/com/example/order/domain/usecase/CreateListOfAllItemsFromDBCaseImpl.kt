package com.example.order.app.domain.usecase

import com.example.order.core.GlobalConstAndVars

import com.example.order.app.domain.model.ListItem
import com.example.order.repository.LocalRepository
import com.example.order.repository.LocalRepositoryImpl
import com.example.order.core.App
import java.math.RoundingMode
import java.text.DecimalFormat

class CreateListOfAllItemsFromDBCaseImpl: CreateListOfAllItemsFromDBCase {



    private val localRepository1C: LocalRepository = LocalRepositoryImpl(App.get1CDAO())


    override suspend fun getListWithAllCells(): List<ListItem> {
        var startList: List<ListItem> = listOf()
        val dataFrom1C: List<ListItem>

        dataFrom1C = localRepository1C.getAllDataDB1CEntity()
        GlobalConstAndVars.listItemFromDb=dataFrom1C
        startList=dataFrom1C
        GlobalConstAndVars.GLOBAL_LIST=startList
        return startList
    }

}











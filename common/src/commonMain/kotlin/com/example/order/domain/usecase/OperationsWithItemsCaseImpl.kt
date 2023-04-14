package com.example.order.app.domain.usecase

/*import android.os.Build*/
import androidx.annotation.RequiresApi
import com.example.order.core.GlobalConstAndVars
import com.example.order.app.domain.model.ListItem
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class OperationsWithItemsCaseImpl : OperationsWithItemsCase {
   /* @RequiresApi(Build.VERSION_CODES.N)*/
    override suspend fun getCellsToOpen(orderNumber: String): List<ListItem> {
        return suspendCoroutine { res ->
            val cellsList = GlobalConstAndVars.GLOBAL_LIST.filter { it.documentFB == orderNumber }

            GlobalConstAndVars.CELLS_LIST = cellsList
            res.resume(cellsList)

        }


    }

    override suspend fun openCellForLoading(goodsArticle: String) {
        val freeCells = GlobalConstAndVars.GLOBAL_LIST

        val cellsQuantity =
            12 //заглушка. сделать метод для опроса ардуины о том сколько у нее ячеек
        val startCell = 2 //заглушка. сделать запрос на ардуину с какой цифры начинать отсчет


    }

    override suspend fun getFreeCellsList(freeCellsList: List<ListItem>) {

    }


}









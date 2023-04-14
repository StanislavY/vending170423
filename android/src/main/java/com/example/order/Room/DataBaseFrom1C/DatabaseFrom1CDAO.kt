package com.example.order.Room.DataBaseFrom1C

import android.database.Cursor
import androidx.room.*
import com.example.order.datasource.Room.DatabaseResult.ResultEntity

@Dao
interface DatabaseFrom1CDAO {

        @Query("SELECT*FROM DatabaseFrom1CEntity")
        fun all1C():List<DatabaseFrom1CEntity>


        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insert(entity: DatabaseFrom1CEntity)

        @Update
        fun update(entity: DatabaseFrom1CEntity)

        @Delete
        fun delete (entity: DatabaseFrom1CEntity)

        @Query("DELETE FROM DatabaseFrom1CEntity")
        fun deleteall()

        @Query("SELECT box, cell, specificationsName FROM DatabaseFrom1CEntity")
        fun getHistoryCursor(): Cursor

        @Query("SELECT box, cell, specificationsName FROM DatabaseFrom1CEntity WHERE box = :id1&cell=:id2")
        fun getHistoryCursor(id1: Int,id2:Int): Cursor

        @Query("SELECT*FROM ResultEntity WHERE value=''")
        fun getAllUnfinishedResult():List<ResultEntity>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertDataToResult(entity: ResultEntity)

        @Query("SELECT*FROM ResultEntity")
        fun allFromResultDB():List<ResultEntity>





}

package com.example.order.Room.DatabaseResult

import android.database.Cursor
import androidx.room.*

@Dao
interface ResultDAO {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun insert(entity: ResultEntity)

        @Update
        fun update(entity: ResultEntity)

        @Delete
        fun delete (entity: ResultEntity)

        @Query("DELETE FROM ResultEntity WHERE id1=:id1&id2=:id2")
        fun deleteById(id1:Int,id2:Int)

        @Query("SELECT id1, id2, name FROM ResultEntity")
        fun getHistoryCursor(): Cursor

        @Query("SELECT id1, id2, name FROM ResultEntity WHERE id1 = :id1&id2=:id2")
        fun getHistoryCursor(id1: Int,id2:Int): Cursor




    }

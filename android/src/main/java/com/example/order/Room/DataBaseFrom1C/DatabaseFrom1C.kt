package com.example.order.Room.DataBaseFrom1C

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.order.datasource.Room.DatabaseResult.ResultEntity

@Database(entities = [DatabaseFrom1CEntity::class, ResultEntity::class],version=2,exportSchema=false)
abstract class DatabaseFrom1C :RoomDatabase() {
    abstract fun databaseFrom1CDAO(): DatabaseFrom1CDAO

}
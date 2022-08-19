package com.prefdb.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prefdb.data.PItem

@Database(entities = [PItem::class], version = 1, exportSchema = false)
abstract class PrefDataBase : RoomDatabase() {
    abstract fun PItemDao(): PItemDao
}
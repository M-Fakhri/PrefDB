package com.prefdb.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prefdb.data.PItem

@Dao
interface PItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: PItem)

    @Query("SELECT value FROM Main WHERE `key` = :key ")
    suspend fun getByKey(key: String): String?

    @Query("DELETE FROM Main")
    suspend fun clearAll(): Int

    @Query("DELETE FROM Main WHERE `key` =:key")
    suspend fun dropByKey(key: String)
}
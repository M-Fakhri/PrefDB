package com.prefdb.utils

import android.content.Context
import androidx.room.Room
import com.prefdb.data.PItem
import com.prefdb.data.source.PrefDataBase
import com.prefdb.data.source.PrefDataSource
import kotlinx.coroutines.runBlocking


object Prefs {
    private lateinit var db: PrefDataBase
    private lateinit var prefDs: PrefDataSource

    fun init(context: Context) {
        db = Room.databaseBuilder(context, PrefDataBase::class.java, "Prefs.db").build()
        prefDs = PrefDataSource(db.PItemDao())
    }

    fun addOrUpdate(key: String, value: String) {
        if (dbInitialization())
            runBlocking {
                prefDs.addNewItem(PItem(key = key, value = value))
            }
    }

    fun getByKey(key: String): String? {
        return if (dbInitialization())
            runBlocking { prefDs.getItemValue(key) }
        else ""
    }

    private fun dbInitialization(): Boolean {
        return if (::prefDs.isInitialized) {
            true
        } else {
            //Throw Initialization Exception
            throw PrefDBException("Pref is not initialized yet, please make sure you used {Pref.init(context)} on your application class.")
        }
    }

    fun clear() {
        runBlocking { prefDs.clearPrefs() }
    }

    fun drop(key: String) {
        runBlocking { prefDs.dropItem(key) }
    }
}
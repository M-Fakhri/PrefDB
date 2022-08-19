package com.prefdb.data.source

import com.prefdb.data.PItem

class PrefDataSource(private val pItemDao: PItemDao) {

    suspend fun addNewItem(item: PItem) {
        pItemDao.insert(item)
    }

    suspend fun clearPrefs() {
        pItemDao.clearAll()
    }
    suspend fun dropItem(key: String){
        pItemDao.dropByKey(key)
    }

    suspend fun getItemValue(key: String): String? = pItemDao.getByKey(key)
}
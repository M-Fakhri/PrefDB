package com.prefdb.utils

operator fun Prefs.set(key: String, value: String): Unit = addOrUpdate(key, value)
operator fun Prefs.set(key: String, value: Int): Unit = addOrUpdate(key, value.toString())
operator fun Prefs.set(key: String, value: Float): Unit = addOrUpdate(key, value.toString())
operator fun Prefs.set(key: String, value: Double): Unit = addOrUpdate(key, value.toString())
operator fun Prefs.set(key: String, value: Boolean): Unit = addOrUpdate(key, value.toString())
operator fun Prefs.set(key: String, value: Long): Unit = addOrUpdate(key, value.toString())
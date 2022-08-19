package com.prefdb.utils

class PrefDBException(private val msg: String) : Exception() {
    override val message: String
        get() = msg
}
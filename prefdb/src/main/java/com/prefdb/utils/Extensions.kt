package com.prefdb.utils

fun Prefs.getString(key: String): String = getOrException(getByKey(key), key)
fun Prefs.getInt(key: String): Int = getOrException(getByKey(key), key)
fun Prefs.getFloat(key: String): Float = getOrException(getByKey(key), key)
fun Prefs.getDouble(key: String): Double = getOrException(getByKey(key), key)
fun Prefs.getBoolean(key: String): Boolean = getOrException(getByKey(key), key)
fun Prefs.getLong(key: String): Long = getOrException(getByKey(key), key)


fun Prefs.getString(key: String, defValue: String = ""): String = getOrDefault(getByKey(key), defValue)
fun Prefs.getInt(key: String, defValue: Int): Int = getOrDefault(getByKey(key), defValue)
fun Prefs.getFloat(key: String, defValue: Float): Float = getOrDefault(getByKey(key), defValue)
fun Prefs.getDouble(key: String, defValue: Double): Double = getOrDefault(getByKey(key), defValue)
fun Prefs.getBoolean(key: String, defValue: Boolean): Boolean =
    getOrDefault(getByKey(key), defValue)

fun Prefs.getLong(key: String, defValue: Long): Long = getOrDefault(getByKey(key), defValue)

inline fun <reified T> getOrException(value: String?, key: String?): T =
    if (value == null) {
        throw PrefDBException("Can't find key '$key', pass a default value to avoid this exception.")
    } else
        try {
            when (T::class) {
                String::class->{
                    value.toString() as T
                }
                Int::class -> {
                    value.toInt() as T
                }
                Long::class -> {
                    value.toLong() as T
                }
                Double::class -> {
                    value.toDouble() as T
                }
                Float::class -> {
                    value.toFloat() as T
                }
                Boolean::class -> {
                    value.toBoolean() as T
                }
                else -> {
                    throw PrefDBException("Unsupported format {${T::class}}")
                }
            }
        } catch (e: Exception) {
            throw PrefDBException("The key '${key}' is not {${T::class.java}}, Please use proper (get) method.")
        }


inline fun <reified T> getOrDefault(value: String?, defValue: T): T =
    if (value == null)
        defValue
    else
        getOrException(value, null)

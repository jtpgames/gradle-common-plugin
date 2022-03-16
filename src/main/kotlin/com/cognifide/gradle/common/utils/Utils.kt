package com.cognifide.gradle.common.utils

import java.util.*

object Utils {

    fun mapOfNonNullValues(vararg entries: Pair<String, String?>): Map<String, String> {
        return mutableMapOf<String, String>().apply {
            for ((k, v) in entries) {
                if (v != null) {
                    put(k, v)
                }
            }
        }
    }

    fun unroll(value: Any?, callback: (Any?) -> Unit) = when (value) {
        is Array<*> -> value.forEach { callback(it) }
        is Iterable<*> -> value.forEach { callback(it) }
        else -> callback(value)
    }
}

fun <T> Iterable<T>.onEachApply(block: T.() -> Unit): Iterable<T> {
    return this.onEach { it.apply(block) }
}

fun <T> T.using(block: T.() -> Unit) {
    with(this, block)
}

fun String.capitalizeChar() = this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

package com.jordansilva.mywallet.util

import java.text.NumberFormat
import java.util.*

fun Double.format(digits: Int) = String.format(Locale.getDefault(), "%.${digits}f", this)

fun Double.money() : String {
    val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
    format.currency = Currency.getInstance("EUR")
    return format.format(this)
}
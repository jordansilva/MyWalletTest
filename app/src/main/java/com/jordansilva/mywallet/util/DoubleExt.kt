package com.jordansilva.mywallet.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.format(digits: Int) = String.format(Locale.getDefault(), "%.${digits}f", this)

fun Double.money() : String {
    val otherSymbols = DecimalFormatSymbols()
    otherSymbols.decimalSeparator = ','
    otherSymbols.groupingSeparator = '.'

    val numberFormat = DecimalFormat("' € '0.00", otherSymbols)
    return numberFormat.format(this)
}
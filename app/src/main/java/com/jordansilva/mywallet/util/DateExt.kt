package com.jordansilva.mywallet.util

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*

fun Date.asString(format: SimpleDateFormat) = format.format(this)
fun Date.asString(format: String) = asString(SimpleDateFormat(format, Locale.getDefault()))

val Date.relativeTime: String
    get() = DateUtils.getRelativeTimeSpanString(this.time, Calendar.getInstance(Locale.getDefault()).timeInMillis, 0).toString()

package com.jordansilva.mywallet.util

import android.graphics.PorterDuff
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable

inline var TextView.drawableRight: Int
    get() = 0
    set(value) {
        val drawable = getDrawable(context, value)
        setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
    }

inline var TextView.drawableLeft: Int
    get() = 0
    set(value) {
        val drawable = getDrawable(context, value)
        drawable?.setColorFilter(this.currentTextColor, PorterDuff.Mode.SRC_ATOP)
        setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
    }
